package bem.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_ozveyat{

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
views.get("label7").vw.setWidth((int)((60d / 100 * width)));
views.get("label7").vw.setLeft((int)((35d / 100 * width)));
views.get("label7").vw.setHeight((int)((7d / 100 * height)));
views.get("label3").vw.setTop((int)((10d / 100 * height)));
views.get("label3").vw.setWidth((int)((90d / 100 * width)));
views.get("label3").vw.setHeight((int)((10d / 100 * height)));
views.get("label3").vw.setLeft((int)((5d / 100 * width)));
views.get("label1").vw.setTop((int)((views.get("label3").vw.getTop())+(views.get("label3").vw.getHeight())+(5d / 100 * height)));
views.get("label1").vw.setLeft((int)((62d / 100 * width)));
views.get("label1").vw.setWidth((int)((35.5d / 100 * width)));
views.get("label1").vw.setHeight((int)((10d / 100 * height)));
views.get("label2").vw.setTop((int)((views.get("label1").vw.getTop())+(views.get("label1").vw.getHeight())+(5d / 100 * height)));
views.get("label2").vw.setLeft((int)((62d / 100 * width)));
views.get("label2").vw.setWidth((int)((35.5d / 100 * width)));
views.get("label2").vw.setHeight((int)((10d / 100 * height)));
views.get("button2").vw.setTop((int)((views.get("label2").vw.getTop())+(views.get("label2").vw.getHeight())+(3d / 100 * height)));
views.get("button2").vw.setHeight((int)((10d / 100 * height)));
views.get("button2").vw.setWidth((int)((35d / 100 * width)));
views.get("button2").vw.setLeft((int)((60d / 100 * width)));
views.get("button1").vw.setTop((int)((views.get("label2").vw.getTop())+(views.get("label2").vw.getHeight())+(3d / 100 * height)));
views.get("button1").vw.setWidth((int)((35d / 100 * width)));
views.get("button1").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 37;BA.debugLine="Button1.Left=5%x"[ozveyat/General script]
views.get("button1").vw.setLeft((int)((5d / 100 * width)));
//BA.debugLineNum = 39;BA.debugLine="EditText1.Top=Label3.Top+Label3.Height+5%y"[ozveyat/General script]
views.get("edittext1").vw.setTop((int)((views.get("label3").vw.getTop())+(views.get("label3").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 40;BA.debugLine="EditText1.Height=10%y"[ozveyat/General script]
views.get("edittext1").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 41;BA.debugLine="EditText1.Width=55%x"[ozveyat/General script]
views.get("edittext1").vw.setWidth((int)((55d / 100 * width)));
//BA.debugLineNum = 42;BA.debugLine="EditText1.Left=7%x"[ozveyat/General script]
views.get("edittext1").vw.setLeft((int)((7d / 100 * width)));
//BA.debugLineNum = 44;BA.debugLine="EditText2.Top=EditText1.Top+EditText1.Height+5%y"[ozveyat/General script]
views.get("edittext2").vw.setTop((int)((views.get("edittext1").vw.getTop())+(views.get("edittext1").vw.getHeight())+(5d / 100 * height)));
//BA.debugLineNum = 45;BA.debugLine="EditText2.Height=10%y"[ozveyat/General script]
views.get("edittext2").vw.setHeight((int)((10d / 100 * height)));
//BA.debugLineNum = 46;BA.debugLine="EditText2.Width=55%x"[ozveyat/General script]
views.get("edittext2").vw.setWidth((int)((55d / 100 * width)));
//BA.debugLineNum = 47;BA.debugLine="EditText2.Left=7%x"[ozveyat/General script]
views.get("edittext2").vw.setLeft((int)((7d / 100 * width)));

}
}