package bem.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_sbank{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("imageview1").vw.setLeft((int)(0d));
views.get("imageview1").vw.setTop((int)(0d));
views.get("imageview1").vw.setWidth((int)((100d / 100 * width)));
views.get("imageview1").vw.setHeight((int)((100d / 100 * height)));
views.get("fakeactionbar").vw.setTop((int)(0d));
views.get("fakeactionbar").vw.setWidth((int)((100d / 100 * width)));
views.get("fakeactionbar").vw.setHeight((int)((8d / 100 * height)));
views.get("label7").vw.setTop((int)((1d / 100 * width)));
views.get("label7").vw.setWidth((int)((50d / 100 * width)));
views.get("label7").vw.setLeft((int)((50d / 100 * width)));
views.get("label7").vw.setHeight((int)((7d / 100 * height)));
views.get("label1").vw.setTop((int)((4d / 100 * height)));
views.get("label1").vw.setHeight((int)((15d / 100 * height)));
views.get("label1").vw.setWidth((int)((90d / 100 * width)));
views.get("label1").vw.setLeft((int)((5d / 100 * width)));
views.get("label2").vw.setTop((int)((views.get("label1").vw.getTop())+(1d / 100 * height)+(views.get("label1").vw.getHeight())));
views.get("label2").vw.setHeight((int)((12d / 100 * height)));
views.get("label2").vw.setWidth((int)((25d / 100 * width)));
views.get("label2").vw.setLeft((int)((72d / 100 * width)));
views.get("label3").vw.setTop((int)((views.get("label2").vw.getTop())+(5d / 100 * height)+(views.get("label2").vw.getHeight())));
views.get("label3").vw.setHeight((int)((12d / 100 * height)));
views.get("label3").vw.setWidth((int)((25d / 100 * width)));
views.get("label3").vw.setLeft((int)((72d / 100 * width)));
views.get("label4").vw.setTop((int)((views.get("label3").vw.getTop())+(5d / 100 * height)+(views.get("label3").vw.getHeight())));
views.get("label4").vw.setHeight((int)((12d / 100 * height)));
views.get("label4").vw.setWidth((int)((25d / 100 * width)));
views.get("label4").vw.setLeft((int)((72d / 100 * width)));
views.get("label5").vw.setTop((int)((views.get("label4").vw.getTop())+(5d / 100 * height)+(views.get("label4").vw.getHeight())));
views.get("label5").vw.setHeight((int)((12d / 100 * height)));
views.get("label5").vw.setWidth((int)((25d / 100 * width)));
views.get("label5").vw.setLeft((int)((72d / 100 * width)));
views.get("button1").vw.setTop((int)((views.get("label5").vw.getTop())+(5d / 100 * height)+(views.get("label5").vw.getHeight())));
views.get("button1").vw.setLeft((int)((52d / 100 * width)));
views.get("button1").vw.setWidth((int)((46d / 100 * width)));
//BA.debugLineNum = 42;BA.debugLine="Button1.Height=7%y"[sbank/General script]
views.get("button1").vw.setHeight((int)((7d / 100 * height)));
//BA.debugLineNum = 44;BA.debugLine="Button2.Top=Label5.Top+Label5.Height+5%y"[sbank/General script]
views.get("button2").vw.setTop((int)((views.get("label5").vw.getTop())+(views.get("label5").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 45;BA.debugLine="Button2.Left=2%x"[sbank/General script]
views.get("button2").vw.setLeft((int)((2d / 100 * width)));
//BA.debugLineNum = 46;BA.debugLine="Button2.Width=46%x"[sbank/General script]
views.get("button2").vw.setWidth((int)((46d / 100 * width)));
//BA.debugLineNum = 47;BA.debugLine="Button2.Height=7%y"[sbank/General script]
views.get("button2").vw.setHeight((int)((7d / 100 * height)));
//BA.debugLineNum = 49;BA.debugLine="EditText1.Top=Label1.Top+1%y+Label1.Height"[sbank/General script]
views.get("edittext1").vw.setTop((int)((views.get("label1").vw.getTop())+(1d / 100 * height)+(views.get("label1").vw.getHeight())));
//BA.debugLineNum = 50;BA.debugLine="EditText1.Height=12%y"[sbank/General script]
views.get("edittext1").vw.setHeight((int)((12d / 100 * height)));
//BA.debugLineNum = 51;BA.debugLine="EditText1.Left=2%x"[sbank/General script]
views.get("edittext1").vw.setLeft((int)((2d / 100 * width)));
//BA.debugLineNum = 52;BA.debugLine="EditText1.Width=68%x"[sbank/General script]
views.get("edittext1").vw.setWidth((int)((68d / 100 * width)));
//BA.debugLineNum = 54;BA.debugLine="EditText2.Top=EditText1.Top+5%y+EditText1.Height"[sbank/General script]
views.get("edittext2").vw.setTop((int)((views.get("edittext1").vw.getTop())+(5d / 100 * height)+(views.get("edittext1").vw.getHeight())));
//BA.debugLineNum = 55;BA.debugLine="EditText2.Height=12%y"[sbank/General script]
views.get("edittext2").vw.setHeight((int)((12d / 100 * height)));
//BA.debugLineNum = 56;BA.debugLine="EditText2.Left=2%x"[sbank/General script]
views.get("edittext2").vw.setLeft((int)((2d / 100 * width)));
//BA.debugLineNum = 57;BA.debugLine="EditText2.Width=68%x"[sbank/General script]
views.get("edittext2").vw.setWidth((int)((68d / 100 * width)));
//BA.debugLineNum = 59;BA.debugLine="EditText3.Top=EditText2.Top+5%y+EditText2.Height"[sbank/General script]
views.get("edittext3").vw.setTop((int)((views.get("edittext2").vw.getTop())+(5d / 100 * height)+(views.get("edittext2").vw.getHeight())));
//BA.debugLineNum = 60;BA.debugLine="EditText3.Height=12%y"[sbank/General script]
views.get("edittext3").vw.setHeight((int)((12d / 100 * height)));
//BA.debugLineNum = 61;BA.debugLine="EditText3.Left=2%x"[sbank/General script]
views.get("edittext3").vw.setLeft((int)((2d / 100 * width)));
//BA.debugLineNum = 62;BA.debugLine="EditText3.Width=68%x"[sbank/General script]
views.get("edittext3").vw.setWidth((int)((68d / 100 * width)));
//BA.debugLineNum = 64;BA.debugLine="EditText4.Top=EditText3.Top+5%y+EditText3.Height"[sbank/General script]
views.get("edittext4").vw.setTop((int)((views.get("edittext3").vw.getTop())+(5d / 100 * height)+(views.get("edittext3").vw.getHeight())));
//BA.debugLineNum = 65;BA.debugLine="EditText4.Height=12%y"[sbank/General script]
views.get("edittext4").vw.setHeight((int)((12d / 100 * height)));
//BA.debugLineNum = 66;BA.debugLine="EditText4.Left=2%x"[sbank/General script]
views.get("edittext4").vw.setLeft((int)((2d / 100 * width)));
//BA.debugLineNum = 67;BA.debugLine="EditText4.Width=68%x"[sbank/General script]
views.get("edittext4").vw.setWidth((int)((68d / 100 * width)));

}
}