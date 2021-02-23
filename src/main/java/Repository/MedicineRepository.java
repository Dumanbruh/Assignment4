package Repository;

import Database.Database;
import Database.IDB;
import Entities.Medicine;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MedicineRepository implements MedicineRepositoryInterface{
    @Inject
    private IDB db;
    @Inject
    private final Database databasemanager;

    public MedicineRepository(Database databasemanager) {
        this.databasemanager = databasemanager;
    }

    @Override
    public List<Medicine> findbyname(String name) {
        Connection con = null;

        try{
            con = db.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM Medicine WHERE name LIKE '%" + name + "%'");

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Medicine> medicines = new LinkedList<>();

            while(resultSet.next()){
                Medicine medicine = new Medicine(
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getDate("localdate").toLocalDate(),
                        resultSet.getInt("weight")
                );
                medicines.add(medicine);

            }
            return medicines;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Medicine getMedicineId(int id) {
        Connection con = null;

        try{
            con = databasemanager.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM Medicine WHERE id = ? ");
            preparedStatement.setInt(1,id);


            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Medicine medicine = new Medicine(
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getDate("localdate").toLocalDate(),
                        resultSet.getInt("weight")
                );
                return medicine;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addMedicine(Medicine medicine) {
        Connection connection = null;
        try{
            connection = databasemanager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Medicine(name,price,manufacturer,localdate,weight) VALUES(?,?,?,?,?)");

            preparedStatement.setString(1, medicine.getName());
            preparedStatement.setInt(2, medicine.getPrice());
            preparedStatement.setString(3, medicine.getManufacturer());
            preparedStatement.setDate(4, Date.valueOf(medicine.getLocaldate()));
            preparedStatement.setInt(5, medicine.getWeight());

            preparedStatement.executeUpdate();

            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeMedicine(int id) {
        Connection connection = null;

        try {
            connection = databasemanager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Medicine WHERE id = ?");

            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Medicine getMedicineWeight(int weight) {
        Connection connection = null;

        try{
            connection = databasemanager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Medicine WHERE weight = ?");

            preparedStatement.setInt(1,weight);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Medicine medicine = new Medicine(
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getDate("localdate").toLocalDate(),
                        resultSet.getInt("weight")
                );
                return medicine;
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
