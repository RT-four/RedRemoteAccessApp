package com.rtfour.RemoteRed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Controller
public class RemoteController {

    static String port = "8181";

    @GetMapping("/")
    public String main() {
        return "choice";
    }

    @PostMapping("/clientConnection")
    public String handleData(@RequestParam("password") String password, @RequestParam("ip") String ip,
                                 RedirectAttributes redirectAttributes) throws SQLException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, ClassNotFoundException {
        if(new conn_establish().findInBD(ip, password)){
            new StartClient().initialize(ip, Integer.parseInt(port), password);
        }
        return "main";
    }
    @PostMapping("/serverCreating")
    public String handlePassword(@RequestParam("password") String password,
                                 RedirectAttributes redirectAttributes) throws SQLException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, ClassNotFoundException {
        new StartServer().start(password);
        return "main";
    }
    @PostMapping("/client")
    public String loadClient() throws SQLException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, ClassNotFoundException {
        return "main";
    }
    @PostMapping("/server")
    public String loadServer() throws SQLException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, ClassNotFoundException {
        return "createConnection";
    }

}