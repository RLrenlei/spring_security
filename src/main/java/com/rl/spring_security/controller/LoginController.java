package com.rl.spring_security.controller;

import com.rl.spring_security.util.VerifyCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Ren
 * @description 一些登录相关的接口
 * @date 2021/12/30 14:20
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final int IMG_WIDTH = 200;
    private static final int IMG_HEIGHT = 69;

    @GetMapping("/getVerifyCode")
    public void getVerificationCode(HttpServletRequest request, HttpServletResponse response) {
        // 生成对应宽高的初始图片
        BufferedImage verifyImg = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_BGR);
        // 生成验证码字符并加上噪点，干扰线，返回值为验证码字符串
        String randomText = VerifyCode.drawRandomText(IMG_WIDTH, IMG_HEIGHT, verifyImg);
        request.getSession().setAttribute("verfifyCode", randomText);
        response.setContentType("image/png"); //设置为图片
        try {
            OutputStream os = response.getOutputStream();
            ImageIO.write(verifyImg, "png", os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
