import java.sql.*;

public class Main {
    public static void main(String[] args) {
        ResultSet resultSet = selectAllFrom("cars");
        if(resultSet != null){
            try {
                ResultSetMetaData metadata = resultSet.getMetaData();
                int columnCount = metadata.getColumnCount();
                for (int i = 1; i <= columnCount; i++)
                    System.out.print(metadata.getColumnName(i) + "\t");
                System.out.println("\n");

                while (resultSet.next()) {
                    for (int i = 1; i <= columnCount; i++)
                        System.out.print(resultSet.getString(i) + "\t");
                    System.out.println();
                }
                System.out.println();

                resultSet.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        addNewCar("brand1", "model", "bodyStyle", "2014-01-28", "color", 123D);
        deleteCarById(10);
        updateCarsBrand("newBrand1", 5);

    }

    /***
     * Подключается к базе данных 
     */
    private static Connection getConnection(){
        final String databaseURL = "jdbc:mysql://localhost:3306/week4";
        final String userName = "root";
        final String password = "pa$$word";

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// com.mysql.cj.jdbc.Driver   com.mysql.jdbc.Driver
            connection = DriverManager.getConnection(databaseURL,userName,password);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /***
     * находит запись в таблице "cars" по id, и изменяет содержимое столбца brand на заданную строку
     * @param brand - новое значение для столбца brand
     * @param id - id записи.
     */
    private static void updateCarsBrand(String brand, long id){
        Connection connection = getConnection();
        if(connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cars SET brand = ? WHERE id = ?");
                preparedStatement.setString(1, brand);
                preparedStatement.setDouble(2, id);

                int val = preparedStatement.executeUpdate();
                preparedStatement.close();
                System.out.println(val + " records were updated");

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /***
     * Удаляет запись из таблицы "cars" по id
     * @param id - id записи, которую требуется удалить
     */
    private static void deleteCarById(long id){
        PreparedStatement preparedStatement = null;

        Connection connection = getConnection();
        if(connection != null) {
            try {
                preparedStatement = connection.prepareStatement("DELETE FROM cars WHERE id = ?;");
                preparedStatement.setLong(1, id);

                int val = preparedStatement.executeUpdate();
                preparedStatement.close();
                System.out.println(val + " records were deleted");

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /***
     * Данный метод додавляет новую запись в таблицу "cars"
     *
     * все параметры представляют собой столбцы таблицы
     * не принимает id т.к. база сгенерирует (auto increment)
     */
    private static void addNewCar(String brand, String model, String bodyStyle, String yearOfManufacture, String color, double price) {
        Connection connection = getConnection();
        if(connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into cars (brand, model, body_style, year_of_manufacture, color, price) values(?, ?, ?, ?, ?, ?)");
                preparedStatement.setString(1, brand);
                preparedStatement.setString(2, model);
                preparedStatement.setString(3, bodyStyle);
                preparedStatement.setString(4, yearOfManufacture);
                preparedStatement.setString(5, color);
                preparedStatement.setDouble(6, price);

                int val = preparedStatement.executeUpdate();
                preparedStatement.close();
                System.out.println(val + " records were added to cars");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /***
     *
     * @param tableName - имя таблицы
     * @return объект ResultSet, в котором полное содержимое таблицы
     */
    private static ResultSet selectAllFrom(String tableName) {
        ResultSet resultSet = null;

        Connection connection = getConnection();
        if(connection != null) {
            String query = "select * from " + tableName;
            try {
                Statement statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultSet;
    }


}
