package cn.lp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.controller
 * @Author: lp
 * @CreateTime: 2025-09-12  14:27
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
@RequestMapping("testOriginController")
@RestController
public class TestOriginController {
    @GetMapping("/redirect")
    public RedirectView redirectToPayConfirm() {
        // 重定向到指定的地址
        return new RedirectView("http://localhost:3000/standalone/checkout?intent_id=7647447591194629&client_secret=eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ0YXJnZXRPcmciOiJwYXljbyIsImNvdW50cnlfY29kZSI6IktSIiwib3JkZXJBbW91bnQiOiI5OTkiLCJvcmRlckN1cnJlbmN5IjoiS1JXIiwibWVyY2hhbnRJZCI6IjIwMjIwMDAwMDAwMDg0NTQiLCJtZXJjaGFudE9yZGVySWQiOiIyMDI1MDIyNDEwMzkzNzA0MSIsInR4bk9yZGVySWQiOiI3NjQ3NDQ3NTkxMTk0NjI5Iiwia2V5IjoiMDU2YzdiNDEtYmY1MC00OTUyLWJmN2UtNmRjM2I5MWZjMzY5IiwiZGF0ZXRpbWUiOiIyMDI1LTA5LTEyVDA2OjA2OjI5LjczNjEyODMyNloiLCJleHAiOjE3NTc2NjA3ODl9.JvA00pmr-h0c26bhMl8m33twHsmQLJDKLcSEd90Csp-udYVXRYee5DUClLI47MspZxK0DnsUwCO71YiGDS5TAQ&mode=payment&currency=KRW&timeOut=2025-09-16%2018:06:29&targetOrg=payco&appVersion=v1.938.2");
    }
}
