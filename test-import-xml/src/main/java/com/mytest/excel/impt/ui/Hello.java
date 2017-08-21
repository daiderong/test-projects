package com.mytest.excel.impt.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;
/**
 * swing基础实例
 * @author HZ20232
 *
 */
public class Hello{
    public static void main(String args[])throws Exception{
        NewFrame frame1 = new NewFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//一定要设置关闭

        frame1.setVisible(true);
    }
}
class NewFrame extends JFrame{
    private JLabel label1;
    private JButton button1;
    private JTextField text1;
    private JComboBox box;
    private JComboBox box2;
    private JMenuBar menuBar;
    private JSlider slider;
    private JSpinner spinner;
    private JToolBar toolBar;
    
    private JButton submit;
    
    
    
    
//    private JTextField  text4YYMC; //;
    
    
//    private String XZQHDM = "310000";
//	private String YYID = "13390";
//	private String YYMC = "长海医院";
//	private DataBaseType dbtype = DataBaseType.MYSQL;
    
    
    public NewFrame(){
        super();
        this.setSize(500,500);
        Toolkit kit = Toolkit.getDefaultToolkit();    // 定义工具包

        Dimension screenSize = kit.getScreenSize();   // 获取屏幕的尺寸

        int screenWidth = screenSize.width/2;         // 获取屏幕的宽

        int screenHeight = screenSize.height/2;       // 获取屏幕的高
        int height = this.getHeight();
        int width = this.getWidth();
        setLocation(screenWidth-width/2, screenHeight-height/2);
       
        
        
        
        
        this.getContentPane().setLayout(null);//设置布局控制器

//        this.getContentPane().setLayout(new FlowLayout());//设置布局控制器

//        this.getContentPane().setLayout(new GridLayout(2,10));//设置布局控制器,需要给出设定的行列数目

        this.getContentPane().setLayout(new BorderLayout());//设置布局控制器，以North,South,West,East，来控制控件布局

//        this.getContentPane().setLayout(new GridBagLayout());//设置布局控制器

        this.add(this.getTextField(),null);//添加文本框

        this.add(this.getButton(),null);//添加按钮

        this.add(this.getLabel(),null);//添加标签
        this.add(this.getBox(),null);//添加下拉列表框
        box2 = new JComboBox();
        box2.setBounds(103,70,150,27);
        box2.addItem("上海(31000)");
        box2.setBounds(103,100,150,27);

        this.add(box2,null);//添加下拉列表框

//        this.setJMenuBar(this.getMenu());//添加菜单

//        this.add(this.getSpinner(),null);
        this.add(this.getToolBar(),null);
//        this.setTitle("Hello World!");//设置窗口标题
        text1.setText("原始文件");
        text1.setEditable(false);
      
        submit = new JButton("执行导入");
        this.add(submit);
        submit.setBounds(140,150,50,27);
        
    }
    private JToolBar getToolBar(){
        if(toolBar==null){
            toolBar = new JToolBar();
            toolBar.setBounds(103,260,71,20);
            toolBar.setFloatable(true);
        }
        return toolBar;
    }
//    private JSpinner getSpinner(){
//        if(spinner==null){
//            spinner = new JSpinner();
//            spinner.setBounds(103,220, 80,20);
//            spinner.setValue(100);
//        }
//        return spinner;
//    }
//    private JSlider getSlider(){
//        if(slider==null){
//            slider = new JSlider();
//            slider.setBounds(103,200,100, 20);
//            slider.setMaximum(100);
//            slider.setMinimum(0);
//            slider.setOrientation(0);
//            slider.setValue(0);
//        }
//        return slider;
//    }
    /**
     * 菜单的级别JMenuBar->JMenu->JMenuItem
     * 三级都是1：n的关系
     * 最后添加菜单用的SetJMenuBar方法
     * @return 建立好的菜单
     */
//    private JMenuBar getMenu(){
//        if(menuBar==null){
//            menuBar = new JMenuBar();
//            JMenu m1 = new JMenu();
//            m1.setText("文件");
//            JMenu m2 = new JMenu();
//            m2.setText("编辑");
//            JMenu m3 = new JMenu();
//            m3.setText("帮助");
//            
//            JMenuItem item11 = new JMenuItem();
//            item11.setText("打开");
//            JMenuItem item12 = new JMenuItem();
//            item12.setText("保存");
//            JMenuItem item13 = new JMenuItem();
//            item13.setText("退出");
//            
//            JMenuItem item21 = new JMenuItem();
//            item21.setText("复制");
//            JMenuItem item22 = new JMenuItem();
//            item22.setText("拷贝");
//            JMenuItem item23 = new JMenuItem();
//            item23.setText("剪切");
//            
//            JMenuItem item31 = new JMenuItem();
//            item31.setText("欢迎");
//            JMenuItem item32 = new JMenuItem();
//            item32.setText("搜索");
//            JMenuItem item33 = new JMenuItem();
//            item33.setText("版本信息");
//            
//            m1.add(item11);
//            m1.add(item12);
//            m1.add(item13);
//            
//            m2.add(item21);
//            m2.add(item22);
//            m2.add(item23);
//            
//            m3.add(item31);
//            m3.add(item32);
//            m3.add(item33);
//            
//            menuBar.add(m1);
//            menuBar.add(m2);
//            menuBar.add(m3);
//        }
//        return menuBar;
//    }
    /**
     * 设置下拉列表框
     * @return
     */
    private JComboBox getBox(){
        if(box==null){
            box = new JComboBox();
            box.setBounds(103,70,150,27);
            box.addItem("长海医院(13390)");
            box.addActionListener(new comboxListener());//为下拉列表框添加监听器类

        }
        return box;
    }
    private class comboxListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Object o = e.getSource();
            System.out.println(o.toString());
        }
    }
    /**
     * 设置标签
     * @return 设置好的标签
     */
    private JLabel getLabel(){
        if(label1==null){
            label1 = new JLabel();
            label1.setBounds(34,49,53,18);
            label1.setText("文件地址");
            label1.setToolTipText("JLabel");
        }
        return label1;
    }
    /**
     * 设置按钮
     * @return 设置好的按钮
     */
    private JButton getButton(){
        if(button1==null){
            button1 = new JButton();
            button1.setBounds(300,49,50,18);
            button1.setText("文件");
            button1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser jfc=new JFileChooser();  
			        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
			        jfc.showDialog(new JLabel(), "选择");  
			        File file=jfc.getSelectedFile();  
			        if(file != null){
			        	if(file.isDirectory()){  
				            text1.setText(file.getAbsolutePath());  
				        }else if(file.isFile()){  
//				            System.out.println("文件:"+file.getAbsolutePath()); 
				            text1.setText(file.getAbsolutePath()); 
				        }  
			        }
			        
//			        System.out.println(jfc.getSelectedFile().getName());  
			          
				}
			});
            button1.setToolTipText("OK");
            button1.addActionListener(new HelloButton());//添加监听器类，其主要的响应都由监听器类的方法实现

        }
        return button1;
    }
    /**
     * 监听器类实现ActionListener接口，主要实现actionPerformed方法
     * @author HZ20232
     *
     */
    private class HelloButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("Hello world!");
        }
    }
    /**
     * 设定文本域
     * @return
     */
    private JTextField getTextField(){
        if(text1==null){
            text1 = new JTextField();
            text1.setBounds(96,49,180,20);
        }
        return text1;
    }
}