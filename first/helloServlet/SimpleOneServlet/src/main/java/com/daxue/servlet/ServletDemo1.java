package com.daxue.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author daxue0929
 * @date 2023/7/22
 * 请求地址: http://localhost:9090/SimpleOneServlet/demo1
 * 1. Servlet由谁创建? Servlet方法由谁调用?
 *  Servlet由web服务器创建,Servlet方法由web服务器调用
 * 2. 服务器怎么知道Servlet一定有service方法?
 *  因为我们自定义的Servlet,必须实现servlet接口并复写其方法,而servlet接口中有service方法.
 *
 * Servlet生命周期:
 *  概念:
 *      对象的生命周期指一个对象从被创建到销毁的过程。
 *  生命周期具体过程:
 *      Servlet运行在Servlet容器(web容器)中,其生命周期由容器来进行管理,分为四个阶段:
 *          1. 加载和实例化(创建)
 *              默认情况下，当servlet第一次被访问时，由容器创建Servlet对象,当然也可以自己修改默认配置,
 *              如果想让服务器在启动时就创建Servlet对象,只需要在注解里面加入loadOnStartup=0或正整数即可，
 *              数字越小优先级越高，即: @WebServlet(urlPatterns=“/demo”,loadOnStartup=1)
 *          2. 初始化
 *              在Servlet实例化后，容器将调用Servlet的init()方法初始化这个对象，完成一些如加载配置文件，
 *              创建连接等初始化的工作，该方法只调用一次。
 *          3. 请求处理
 *              每次请求Servlet时,Servlet容器都会调用Servlet的service方法对请求进行处理
 *          4. 服务终止
 *              当需要释放内存或者容器关闭时，容器就会调用Servlet实例的destroy()方法完成资源的释放，
 *              在destroy()方法调用之后，容器会释放这个Servlet实例,该实例随后就会被Java的垃圾收集器所回收
 *
 * 由于直接继承Servlet需要实现里面的所有方法,
 * 每次写代码都需要判断服务器是get请求还是post请求,
 * 使得程序繁琐,所以我们在写程序的时候不再实现Servlet方法,
 * 直接继承HttpServlet类,来重写里面的doGet方法和doPost方法
 */

@WebServlet("/demo1")
public class ServletDemo1 implements Servlet {
    /**
     * 1.调用时机:默认情况下，Servlet被第一次访问。
     * 2.调用次数:1次
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init.....");
    }


    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务
     * 1.调用时机:每一次Servlet被访问的时候
     * 2.调用次数:多次
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日，HH:mm:ss");
        String currentDate = format.format(new Date());
        System.out.println("hello demo1: " + currentDate);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁
     * 1.调用时机:内存释放或者服务器关闭的时候，Servlet对象会被销毁
     * 2.调用次数:1次
     */
    @Override
    public void destroy() {

    }
}
