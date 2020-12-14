package com.example.demo.daoRepository;

import com.example.demo.model.CarBrandModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarBrandRepository {
    @Value("${spring.datasource.driver-class-name}")
    private String JDBC_DRIVER;
    @Value("${spring.datasource.url}")
    private String URL;
    @Value("${spring.datasource.username}")
    private String USER;
    @Value("${spring.datasource.password}")
    private String PASSWORD;

    private final String TABLE_NAME = "car_brands";


    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<CarBrandModel> getAllCarBrands() {
        List<CarBrandModel> list = new ArrayList<>();

        Connection connection = getConnection();
        if(connection != null) {
            String query = "SELECT * FROM " + TABLE_NAME;
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while(resultSet.next()){
                    CarBrandModel carBrand = new CarBrandModel();
                    carBrand.setId(resultSet.getInt("id"));
                    carBrand.setBrand(resultSet.getString("brand"));

                    list.add(carBrand);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public CarBrandModel getBrandById(int id) {
        CarBrandModel carBrandModel = new CarBrandModel();

        Connection connection = getConnection();
        if(connection != null) {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE id = " + id;
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while(resultSet.next()){
                    carBrandModel.setId(resultSet.getInt("id"));
                    carBrandModel.setBrand(resultSet.getString("brand"));
                }


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return carBrandModel;
    }

    public int deleteById(int id) {
        int result = 0;
        Connection connection = getConnection();
        if(connection != null) {
            String query = "DELETE FROM " + TABLE_NAME + " WHERE id = " + id;
            Statement statement = null;
            try {
                statement = connection.createStatement();
                result = statement.executeUpdate(query);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public int addNewBrand(CarBrandModel model) {
        int result = 0;
        String brandName = model.getBrand();

        Connection connection = getConnection();
        if(connection != null && brandName != null && !brandName.isEmpty()) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement("INSERT INTO car_brands (brand) VALUES (?)");
                preparedStatement.setString(1,brandName);
                result =  preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public int update(int id, CarBrandModel model) {
        int result = 0;
        String brandName = model.getBrand();

        Connection connection = getConnection();
        if(connection != null && brandName != null && !brandName.isEmpty()) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement("UPDATE car_brands SET brand = ? WHERE id = ?;");
                preparedStatement.setString(1, brandName);
                preparedStatement.setInt(2, id);
                result =  preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
