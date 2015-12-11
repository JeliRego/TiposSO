package servidores;


import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.*;
public class ServidorHilo extends Thread {
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int idSessio;
    int nip;
    int operacion;//operacion 1=ingresar, opcion 2=quitar
    int monto_ingreso_quitar;
    int tarjeta;
    String id_cliente;
    String id_tarjet;
    String monto_nuevo;
    String monte;
    String monLafer;
    String momo;
    String ni;
    public ServidorHilo(Socket socket, int id) {
        this.socket = socket;
        this.idSessio = id;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void desconnectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run() {
        String accion = "";
        String url ="jdbc:postgresql://localhost:5432/base";
        String user= "postgres";
        String pass="castillosrojos";
        try {
            //Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(url, user, pass);
            java.sql.Statement st = conex.createStatement();
            
            nip=dis.readInt();
            tarjeta=dis.readInt();
            operacion=dis.readInt();
            monto_ingreso_quitar=dis.readInt();
            System.out.println("sql:---> "+nip+tarjeta+operacion+monto_ingreso_quitar);
            
            
            int nuevo_monto=0;
            
            
            //String sql = "SELECT monto FROM cliente WHERE (SELECT nip FROM tarjeta)="+nnip;
            /*System.out.println("sql:---> "+sql);*/
            
            
            switch(operacion)
            {
                case 1:
            
                        String nnip=Integer.toString(nip);
                        String tarj=Integer.toString(tarjeta);
                        String sql ="SELECT id_tarjeta, nip FROM tarjeta WHERE id_tarjeta="+tarj+" AND "+"nip="+nnip;
        //                System.out.println(sql);
                        ResultSet result = st.executeQuery(sql);
                        System.out.println(result);
                        while(result.next())
                        {
                            id_tarjet =result.getString("id_tarjeta");
                            ni = result.getString("nip");
                            System.out.println("Id_tarjeta: "+id_tarjet+"\n:NIP "+ni);

                        }
                        if(id_tarjet!=null && ni!=null)
                        {
                                dos.writeUTF("Cuenta verificada shi");

                                dos.writeInt(1);
                        }
                        else
                        {
                             dos.writeUTF("Cuenta inexistente");
                             dos.writeInt(0);
                        }
                        break;
                case 2:
                        //String nip_quitar=Integer.toString(nip);
                        String tarjeta_quitar=Integer.toString(tarjeta);
                        String aqd="SELECT id_cliente FROM tarjeta WHERE id_tarjeta="+tarjeta_quitar;
                        //String sql ="SELECT id_tarjeta, nip FROM tarjeta WHERE id_tarjeta="+tarj+" AND "+"nip="+nip;
        //                System.out.println(sql);
                        ResultSet quitar = st.executeQuery(aqd);
                        //System.out.println();
                        while(quitar.next())
                        {
                            id_cliente = quitar.getString("id_cliente");
                            System.out.println("Id_cliente: "+id_cliente);

                        }
                        if(id_cliente!=null)
                        {
                            String monto_quitar=Integer.toString(monto_ingreso_quitar);
                            String query="SELECT monto FROM cliente WHERE id_cliente="+id_cliente;
                            ResultSet monto_quitado=st.executeQuery(query);
                            while(monto_quitado.next())
                            {
                                monto_nuevo=monto_quitado.getString("monto");
                            }
                            int nuevo=Integer.parseInt(monto_nuevo);
                            nuevo=nuevo-monto_ingreso_quitar;
                            String cantidad=Integer.toString(nuevo);
                            if(nuevo<=0)
                            {
                                dos.writeUTF("Fondos insuficientes");
                                dos.writeInt(0);
                            }
                            else if(nuevo>0)
                            {
                                String insertar="UPDATE cliente SET monto="+cantidad+" WHERE id_cliente="+id_cliente;
                                st.execute(insertar);
                                st.execute("COMMIT;");
                                String s=Integer.toString(operacion);
                                //String fecha ="2015-08-09";
                                java.util.Date utilDate = new java.util.Date();
                                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                                String fecha= new SimpleDateFormat("yyyy/MM/dd").format(sqlDate);
                                
                                String transaccion = "INSERT INTO transaccion values("+s+",'2015-09-03',"+monto_quitar+","+tarjeta_quitar+")";
                                //String transaccion = "INSERT INTO transaccion (nombre, contraseña) VALUES ('new_name', 'new_Pass')\";"
                                st.execute(transaccion);
                                st.execute("COMMIT;");
                                dos.writeUTF("Monto retirado exitosamente");
                                dos.writeInt(1);
                            }
                            
                        }
                        else
                        {
                             dos.writeUTF("Cliente inexistente");
                             dos.writeInt(0);
                        }
                        break;
                case 3: 
                        //String nip_quitar=Integer.toString(nip);
                        String tarjeta_ingresar=Integer.toString(tarjeta);
                        String ingresar="SELECT id_cliente FROM tarjeta WHERE id_tarjeta="+tarjeta_ingresar;
                        
                        ResultSet ingreso = st.executeQuery(ingresar);
                        //System.out.println();
                        while(ingreso.next())
                        {
                            id_cliente = ingreso.getString("id_cliente");
                            System.out.println("Id_cliente: "+id_cliente);

                        }
                        if(id_cliente!=null)
                        {
                            String monto_quitar=Integer.toString(monto_ingreso_quitar);
                            String query="SELECT monto FROM cliente WHERE id_cliente="+id_cliente;
                            ResultSet monto_quitado=st.executeQuery(query);
                            while(monto_quitado.next())
                            {
                                monto_nuevo=monto_quitado.getString("monto");
                            }
                            int nuevo=Integer.parseInt(monto_nuevo);
                            nuevo=nuevo+monto_ingreso_quitar;
                            String cantidad=Integer.toString(nuevo);
                            
                            String insertar="UPDATE cliente SET monto="+cantidad+" WHERE id_cliente="+id_cliente;
                            st.execute(insertar);
                            st.execute("COMMIT;");
                            String s=Integer.toString(operacion);
                            String transaccion = "INSERT INTO transaccion values("+s+",'2015-09-03',"+monto_quitar+","+tarjeta_ingresar+")";
                            //String transaccion = "INSERT INTO transaccion (nombre, contraseña) VALUES ('new_name', 'new_Pass')\";"
                            st.execute(transaccion);
                            st.execute("COMMIT;");
                            dos.writeUTF("Monto añadido exitosamente");
                            dos.writeInt(1);
                        }else
                        {
                             dos.writeUTF("Cliente inexistente");
                             dos.writeInt(0);
                        }
                        break;
                case 4:
                        String nipcon=Integer.toString(nip);
                        String tarcon=Integer.toString(tarjeta);
                        String consulta = "SELECT monto FROM cliente WHERE id_cliente=(SELECT id_cliente FROM tarjeta WHERE id_tarjeta="+tarcon+")"; 
                        ResultSet consul = st.executeQuery(consulta);
                        while(consul.next())
                        {
                            monLafer=consul.getString("monto");
                        }
                        if(monLafer!=null)
                        {
                            dos.writeUTF(monLafer);
                            dos.writeInt(1);
                        }else
                        {
                            dos.writeUTF("No se pudo realizar la consulta");
                            dos.writeInt(0);
                        }
                        break;
                case 5:
                        String nnp=Integer.toString(nip);
                        String tar=Integer.toString(tarjeta);
                        String sq ="SELECT id_tarjeta, nip FROM tarjeta WHERE id_tarjeta="+tar+" AND "+"nip="+nnp;
        //                System.out.println(sql);
                        ResultSet resu = st.executeQuery(sq);
                        System.out.println(resu);
                        while(resu.next())
                        {
                            id_tarjet =resu.getString("id_tarjeta");
                            ni = resu.getString("nip");
                            System.out.println("Id_tarjeta: "+id_tarjet+"\n:NIP "+ni);

                        }
                        if(id_tarjet!=null && ni!=null)
                        {
                            int nuevo=0;   
                            String monto_quitar=Integer.toString(monto_ingreso_quitar);
                            String tarjet=Integer.toString(tarjeta);
                            String ingre="SELECT id_cliente FROM tarjeta WHERE id_tarjeta="+tarjet;
                        
                            ResultSet ing = st.executeQuery(ingre);
                        
                            while(ing.next())
                            {
                                 id_cliente = ing.getString("id_cliente");
                                System.out.println("Id_cliente: "+id_cliente);

                            }
                            System.out.println("MONTOQUITAR:"+monto_quitar);
                            String query="SELECT monto FROM cliente WHERE id_cliente="+id_cliente;
                            ResultSet monto_quitado=st.executeQuery(query);
                            while(monto_quitado.next())
                            {
                               nuevo=monto_quitado.getInt("monto");
                            }
                            System.out.println("NUEVO1:"+nuevo);
                            nuevo=nuevo-monto_ingreso_quitar;
                            System.out.println("NUEVO2:"+nuevo);
                            String cantidad=Integer.toString(nuevo);
                            if(nuevo<=0)
                            {
                                dos.writeUTF("Fondos insuficientes");
                                dos.writeInt(0);
                            }
                            else if(nuevo>0)
                            {
                                String insertar="UPDATE cliente SET monto="+cantidad+" WHERE id_cliente="+id_cliente;
                                st.execute(insertar);
                                st.execute("COMMIT;");
                                String s=Integer.toString(operacion);
                                //String fecha ="2015-08-09";
                                java.util.Date utilDate = new java.util.Date();
                                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                                String fecha= new SimpleDateFormat("yyyy/MM/dd").format(sqlDate);
                                
                                String transaccion = "INSERT INTO transaccion values("+s+",'2015-09-03',"+monto_quitar+","+tar+")";
                                
                                st.execute(transaccion);
                                st.execute("COMMIT;");
                                dos.writeUTF("Monto retirado exitosamente");
                                dos.writeInt(1);
                            }
                            
                        
                                //------------------------------------------------------------------------------>
                                dos.writeUTF("Cuenta verificada");

                                dos.writeInt(1);
                        }
                        else
                        {
                             dos.writeUTF("Cuenta inexistente");
                             dos.writeInt(0);
                        }
                        break;
                case 6:
                        int monticulo=0;
                        String monto=Integer.toString(monto_ingreso_quitar);
                        String tarjet=Integer.toString(tarjeta);
                        String nipp = Integer.toString(nip);
                        String ingre="SELECT id_cliente FROM tarjeta WHERE id_tarjeta="+tarjet;
                        ResultSet ing = st.executeQuery(ingre);
                        while(ing.next())
                        {
                            id_cliente = ing.getString("id_cliente");
                            System.out.println("Id_cliente: "+id_cliente);
                        }
                        String querymon = "SELECT monto FROM cliente WHERE id_cliente="+id_cliente;
                        ResultSet fra = st.executeQuery(querymon);
                        while (fra.next())
                        {
                            momo=fra.getString("monto");
                            System.out.println("Monto6: "+momo);
                        }
                       
                        monticulo= Integer.parseInt(momo);
                        if(monticulo>0 && monto_ingreso_quitar<monticulo)
                        {
                           
                            monticulo=monticulo-monto_ingreso_quitar;
                            String mono=Integer.toString(monticulo);
                            String mm=Integer.toString(monto_ingreso_quitar);
                            String qrycliente="UPDATE cliente SET monto="+mono+" WHERE id_cliente="+id_cliente;
                            st.execute(qrycliente);
                            st.execute("COMMIT;");
                            String qrycliente2="UPDATE cliente2 SET monto="+mm+" WHERE id_cliente="+id_cliente;
                            st.execute(qrycliente2);
                            st.execute("COMMIT;");
                            String s = Integer.toString(operacion);
                            String transaccion = "INSERT INTO transaccion values("+s+",'2015-09-03',"+mm+","+tarjet+")";
                            st.execute(transaccion);
                            st.execute("COMMIT;");
                            String transaccion2 = "INSERT INTO transaccion2 values("+s+",'2015-09-03',"+mm+","+tarjet+")";
                            st.execute(transaccion2);
                            st.execute("COMMIT;");
                            dos.writeUTF("Monto trasladado a Banco Los conejos desollados");
                            dos.writeInt(1);
                        }else
                        {
                            dos.writeUTF("Fondos insuficientes para realizar la trasacción");
                            dos.writeInt(0);
                        }
                        break;
                case 7:        
                        String nnnp=Integer.toString(nip);
                        String tarr=Integer.toString(tarjeta);
                        String sqq ="SELECT id_tarjeta, nip FROM tarjeta WHERE id_tarjeta="+tarr+" AND "+"nip="+nnnp;
        //                System.out.println(sql);
                        ResultSet res = st.executeQuery(sqq);
                        System.out.println(res);
                        while(res.next())
                        {
                            id_tarjet =res.getString("id_tarjeta");
                            ni = res.getString("nip");
                            System.out.println("Id_tarjeta: "+id_tarjet+"\n:NIP "+ni);

                        }
                        if(id_tarjet!=null && ni!=null)
                        {
                            int nuevo=0;   
                            String monto_quitar=Integer.toString(monto_ingreso_quitar);
                            String tarjett=Integer.toString(tarjeta);
                            String ingree="SELECT id_cliente FROM tarjeta WHERE id_tarjeta="+tarjett;
                        
                            ResultSet ingg = st.executeQuery(ingree);
                        
                            while(ingg.next())
                            {
                                 id_cliente = ingg.getString("id_cliente");
                                System.out.println("Id_cliente: "+id_cliente);

                            }
                            System.out.println("MONTOQUITAR:"+monto_quitar);
                            String query="SELECT monto FROM cliente WHERE id_cliente="+id_cliente;
                            ResultSet monto_quitado=st.executeQuery(query);
                            while(monto_quitado.next())
                            {
                               nuevo=monto_quitado.getInt("monto");
                            }
                            System.out.println("NUEVO1:"+nuevo);
                            nuevo=nuevo-monto_ingreso_quitar;
                            System.out.println("NUEVO2:"+nuevo);
                            String cantidad=Integer.toString(nuevo);
                            if(nuevo<=0)
                            {
                                dos.writeUTF("Fondos insuficientes");
                                dos.writeInt(0);
                            }
                            else if(nuevo>0)
                            {
                                String insertar="UPDATE cliente SET monto="+cantidad+" WHERE id_cliente="+id_cliente;
                                st.execute(insertar);
                                st.execute("COMMIT;");
                                String s=Integer.toString(operacion);
                                //String fecha ="2015-08-09";
                                java.util.Date utilDate = new java.util.Date();
                                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                                String fecha= new SimpleDateFormat("yyyy/MM/dd").format(sqlDate);
                                
                                String transaccion = "INSERT INTO transaccion values("+s+",'2015-09-03',"+monto_quitar+","+tarr+")";
                                
                                st.execute(transaccion);
                                st.execute("COMMIT;");
                                dos.writeUTF("Monto retirado exitosamente");
                                dos.writeInt(1);
                            }
                            
                        
                                //------------------------------------------------------------------------------>
                                dos.writeUTF("Cuenta verificada shi");

                                dos.writeInt(1);
                        }
                        else
                        {
                             dos.writeUTF("Cuenta inexistente");
                             dos.writeInt(0);
                        }
                        break;
                    
            }
            
            //accion = dis.readUTF();
            if(accion.equals("hola")){
                System.out.println("El cliente con idSesion "+this.idSessio+" saluda");
                dos.writeUTF("adios");
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconnectar();
    }
}
