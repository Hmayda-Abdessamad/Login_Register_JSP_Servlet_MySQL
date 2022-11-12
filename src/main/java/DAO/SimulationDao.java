package DAO;
import classes.Simulation;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class SimulationDao {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?useSSL=false","root","");
        }catch(Exception e){System.out.println(e);}
        return con;
    }
    public static int save(Simulation e){
        int status=0;
        try{
            Connection con=SimulationDao.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "insert into simulation( id,  montant,  duree,  taux,  mensualite, date ,categorie) values (?,?,?,?,?,?,?)");
            ps.setInt(1,e.getId());
            ps.setDouble(2,e.getMontant());
            ps.setInt(3,e.getDuree());
            ps.setDouble(4,e.getTaux());
            ps.setDouble(5,e.getMensualite());
            ps.setString(6,e.getDate());
            ps.setString(7,e.getCategorie());
            status=ps.executeUpdate();
            con.close();
        }catch(Exception ex){ex.printStackTrace();}
        return status;
    }
    public static int update(Simulation e){
        int status=0;
        try{
            Connection con=SimulationDao.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "update simulation set montant=?,duree=?,taux=?,mensualite=?,date=?,categorie=? where id=?");
            ps.setDouble(1,e.getMontant());
            ps.setInt(2,e.getDuree());
            ps.setDouble(3,e.getTaux());
            ps.setDouble(4,e.getMensualite());
            ps.setInt(5,e.getId());
            ps.setString(6,e.getDate());
            ps.setString(7,e.getCategorie());
            status=ps.executeUpdate();
            con.close();
        }catch(Exception ex){ex.printStackTrace();}
        return status;
    }
    public static Simulation getSimulationById(int id){
        Simulation e=new Simulation();
        try{
            Connection con=SimulationDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from simulation where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt(1));
                e.setMontant(rs.getDouble(2));
                e.setDuree(rs.getInt(3));
                e.setTaux(rs.getDouble(4));
                e.setMensualite(rs.getDouble(5));
                e.setDate(rs.getString(6));
                e.setCategorie(rs.getString(7));
            }
            con.close();
        }catch(SQLException ex){
            if(e==null) throw new RuntimeException("Simulation introuvable");
            return e;
            }
        return e;
    }
    public static List<Simulation> getAllSimulation(){
        List<Simulation> list=new ArrayList<Simulation>();
        try{
            Connection con=SimulationDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from simulation");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Simulation e=new Simulation();
                e.setId(rs.getInt(1));
                e.setMontant(rs.getDouble(2));
                e.setDuree(rs.getInt(3));
                e.setTaux(rs.getDouble(4));
                e.setMensualite(rs.getDouble(5));
                e.setDate(rs.getString(6));
                e.setCategorie(rs.getString(7));
                list.add(e);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}
        return list;
    }
    public static int delete(int id){
        int status=0;
        int opt= JOptionPane.showConfirmDialog(null,"Are you sure","Delete",JOptionPane.YES_NO_OPTION);
        if(opt==0) {
            try {
                Connection con = SimulationDao.getConnection();
                PreparedStatement ps = con.prepareStatement("delete from simulation where id=?");
                ps.setInt(1, id);
                status = ps.executeUpdate();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return status;
    }
    public static List<Simulation> simulationsParMC(String mc){
        List<Simulation> list=new ArrayList<Simulation>();
        try{
            Connection con=SimulationDao.getConnection();
            String[] tokens = mc.split(" ", 2);


            if (tokens[1].equals("C")) {
                PreparedStatement ps=con.prepareStatement("select * from simulation where categorie like ?");
                ps.setString(1, "%" + tokens[0] + "%");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Simulation e = new Simulation();
                    e.setId(rs.getInt(1));
                    e.setMontant(rs.getDouble(2));
                    e.setDuree(rs.getInt(3));
                    e.setTaux(rs.getDouble(4));
                    e.setMensualite(rs.getDouble(5));
                    e.setDate(rs.getString(6));
                    e.setCategorie(rs.getString(7));
                    list.add(e);
                }

            } else if (tokens[1].equals("D")) {
                int x = Integer.parseInt(tokens[0]);
                PreparedStatement ps=con.prepareStatement("select * from simulation where duree like ?");
                ps.setInt(1,x);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Simulation e = new Simulation();
                    e.setId(rs.getInt(1));
                    e.setMontant(rs.getDouble(2));
                    e.setDuree(rs.getInt(3));
                    e.setTaux(rs.getDouble(4));
                    e.setMensualite(rs.getDouble(5));
                    e.setDate(rs.getString(6));
                    e.setCategorie(rs.getString(7));
                    list.add(e);
                }
            }else if (tokens[1].equals("M")) {
                Double x = Double.parseDouble(tokens[0]);
                PreparedStatement ps = con.prepareStatement("select * from simulation where montant like ?");
                ps.setDouble(1, x);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Simulation e = new Simulation();
                    e.setId(rs.getInt(1));
                    e.setMontant(rs.getDouble(2));
                    e.setDuree(rs.getInt(3));
                    e.setTaux(rs.getDouble(4));
                    e.setMensualite(rs.getDouble(5));
                    e.setDate(rs.getString(6));
                    e.setCategorie(rs.getString(7));
                    list.add(e);
                }
            }else if (tokens[1].equals("T")) {
                Double x = Double.parseDouble(tokens[0]);
                PreparedStatement ps = con.prepareStatement("select * from simulation where taux like ?");
                ps.setDouble(1, x);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Simulation e = new Simulation();
                    e.setId(rs.getInt(1));
                    e.setMontant(rs.getDouble(2));
                    e.setDuree(rs.getInt(3));
                    e.setTaux(rs.getDouble(4));
                    e.setMensualite(rs.getDouble(5));
                    e.setDate(rs.getString(6));
                    e.setCategorie(rs.getString(7));
                    list.add(e);
                }
            }
                con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}