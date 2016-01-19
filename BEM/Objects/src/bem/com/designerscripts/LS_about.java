package bem.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_about{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 1;BA.debugLine="ImageView1.Left=0"[about/General script]
views.get("imageview1").vw.setLeft((int)(0d));
//BA.debugLineNum = 2;BA.debugLine="ImageView1.Top=0"[about/General script]
views.get("imageview1").vw.setTop((int)(0d));
//BA.debugLineNum = 3;BA.debugLine="ImageView1.Width=100%x"[about/General script]
views.get("imageview1").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 4;BA.debugLine="ImageView1.Height=100%y"[about/General script]
views.get("imageview1").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 6;BA.debugLine="fakeActionBar.Top=0"[about/General script]
views.get("fakeactionbar").vw.setTop((int)(0d));
//BA.debugLineNum = 7;BA.debugLine="fakeActionBar.Width=100%x"[about/General script]
views.get("fakeactionbar").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 8;BA.debugLine="fakeActionBar.Height=8%y"[about/General script]
views.get("fakeactionbar").vw.setHeight((int)((8d / 100 * height)));
//BA.debugLineNum = 9;BA.debugLine="Label7.Top=1%x"[about/General script]
views.get("label7").vw.setTop((int)((1d / 100 * width)));
//BA.debugLineNum = 10;BA.debugLine="Label7.Width=60%x"[about/General script]
views.get("label7").vw.setWidth((int)((60d / 100 * width)));
//BA.debugLineNum = 11;BA.debugLine="Label7.Left=40%x"[about/General script]
views.get("label7").vw.setLeft((int)((40d / 100 * width)));
//BA.debugLineNum = 12;BA.debugLine="Label7.Height=7%y"[about/General script]
views.get("label7").vw.setHeight((int)((7d / 100 * height)));
//BA.debugLineNum = 14;BA.debugLine="Label1.Top=8%y"[about/General script]
views.get("label1").vw.setTop((int)((8d / 100 * height)));
//BA.debugLineNum = 15;BA.debugLine="Label1.Height=20%y"[about/General script]
views.get("label1").vw.setHeight((int)((20d / 100 * height)));
//BA.debugLineNum = 16;BA.debugLine="Label1.Width=90%x"[about/General script]
views.get("label1").vw.setWidth((int)((90d / 100 * width)));
//BA.debugLineNum = 17;BA.debugLine="Label1.Left=5%x"[about/General script]
views.get("label1").vw.setLeft((int)((5d / 100 * width)));
//BA.debugLineNum = 18;BA.debugLine="Label4.Top=21%y"[about/General script]
views.get("label4").vw.setTop((int)((21d / 100 * height)));
//BA.debugLineNum = 19;BA.debugLine="Label4.Height=7%y"[about/General script]
views.get("label4").vw.setHeight((int)((7d / 100 * height)));
//BA.debugLineNum = 20;BA.debugLine="Label4.Left=38.5%x"[about/General script]
views.get("label4").vw.setLeft((int)((38.5d / 100 * width)));
//BA.debugLineNum = 21;BA.debugLine="Label4.Width=23%x"[about/General script]
views.get("label4").vw.setWidth((int)((23d / 100 * width)));
//BA.debugLineNum = 23;BA.debugLine="Label6.Top=Label3.Top+9%y+Label3.Height"[about/General script]
views.get("label6").vw.setTop((int)((views.get("label3").vw.getTop())+(9d / 100 * height)+(views.get("label3").vw.getHeight())));
//BA.debugLineNum = 24;BA.debugLine="Label6.Height=9%y"[about/General script]
views.get("label6").vw.setHeight((int)((9d / 100 * height)));
//BA.debugLineNum = 25;BA.debugLine="Label6.Width=85%x"[about/General script]
views.get("label6").vw.setWidth((int)((85d / 100 * width)));
//BA.debugLineNum = 26;BA.debugLine="Label6.Left=15%x"[about/General script]
views.get("label6").vw.setLeft((int)((15d / 100 * width)));
//BA.debugLineNum = 28;BA.debugLine="Label2.Top=Label1.Top+5%y+Label1.Height"[about/General script]
views.get("label2").vw.setTop((int)((views.get("label1").vw.getTop())+(5d / 100 * height)+(views.get("label1").vw.getHeight())));
//BA.debugLineNum = 29;BA.debugLine="Label2.Height=20%y"[about/General script]
views.get("label2").vw.setHeight((int)((20d / 100 * height)));
//BA.debugLineNum = 30;BA.debugLine="Label2.Width=90%x"[about/General script]
views.get("label2").vw.setWidth((int)((90d / 100 * width)));
//BA.debugLineNum = 31;BA.debugLine="Label2.Left=5%x"[about/General script]
views.get("label2").vw.setLeft((int)((5d / 100 * width)));
//BA.debugLineNum = 33;BA.debugLine="Label3.Top=Label2.Top+5%y+Label2.Height"[about/General script]
views.get("label3").vw.setTop((int)((views.get("label2").vw.getTop())+(5d / 100 * height)+(views.get("label2").vw.getHeight())));
//BA.debugLineNum = 34;BA.debugLine="Label3.Height=10%y"[about/General script]
views.get("label3").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 35;BA.debugLine="Label3.Width=90%x"[about/General script]
views.get("label3").vw.setWidth((int)((90d / 100 * width)));
//BA.debugLineNum = 36;BA.debugLine="Label3.Left=5%x"[about/General script]
views.get("label3").vw.setLeft((int)((5d / 100 * width)));

}
}