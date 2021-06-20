package com.rtfour.RemoteRed;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn_establish {

    public static Connection conn;
    public static Statement stat;
    String path_to_json = "D:\\Files\\Programming\\redHackathon\\RemoteRed\\RemoteRed\\src\\main\\java\\com\\rtfour\\RemoteRed\\starter_remote.json";

    static class connection_const {
        public static String url_;
        public static String user_;
        public static String password_;

    }


    public boolean findInBD(String ip, String password) {
        try {
            // Считываем json
            Object obj = new JSONParser().parse(new FileReader(path_to_json));
            JSONObject jo = (JSONObject) obj;
            String url_json = (String) jo.get("url_");
            connection_const.url_ = url_json;
            String user_json = (String) jo.get("user_");
            connection_const.user_ = user_json;
            String password_json = (String) jo.get("password_");
            connection_const.password_ = password_json;
        } catch (ParseException | FileNotFoundException expect_json) {
            expect_json.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            connection_const consts_parser_db = new connection_const();
            conn = DriverManager.getConnection(consts_parser_db.url_, consts_parser_db.user_, consts_parser_db.password_);
            Statement st = conn.createStatement();
            stat = st;
            if (conn != null) {
                System.out.println("Connected to database!");
                if (table_action.table_checker(ip, password)){
                    return true;
                }

            } else {
                System.out.println("No connection to database!");
            }

        } catch (Exception except) {
            System.exit(11111);
        }
        return false;
    }
}



