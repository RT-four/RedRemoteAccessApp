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
    @GetMapping("/")
    public String main() {
        return "main";
    }

    @PostMapping("/")
    public String handlePassword(@RequestParam("password") String password,
                                 RedirectAttributes redirectAttributes) throws SQLException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, ClassNotFoundException {
        String port = "4907";
        new Start().initialize("192.168.1.111", Integer.parseInt(port));
        return "main";
    }

}