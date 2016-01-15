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
views.get("label3").vw.setTop((int)((5d / 100 * height)));
views.get("label3").vw.setWidth((int)((90d / 100 * width)));
views.get("label3").vw.setHeight((int)((20d / 100 * height)));
views.get("label3").vw.setLeft((int)((5d / 100 * width)));
views.get("label1").vw.setTop((int)((views.get("label3").vw.getTop())+(views.get("label3").vw.getHeight())+(5d / 100 * height)));
views.get("label1").vw.setLeft((int)((60d / 100 * width)));
views.get("label1").vw.setWidth((int)((38d / 100 * width)));
views.get("label1").vw.setHeight((int)((20d / 100 * height)));
views.get("label2").vw.setTop((int)((views.get("label1").vw.getTop())+(views.get("label1").vw.getHeight())+(5d / 100 * height)));
views.get("label2").vw.setLeft((int)((60d / 100 * width)));
views.get("label2").vw.setWidth((int)((38d / 100 * width)));
views.get("label2").vw.setHeight((int)((20d / 100 * height)));
views.get("button2").vw.setTop((int)((views.get("label2").vw.getTop())+(views.get("label2").vw.getHeight())+(5d / 100 * height)));
views.get("button2").vw.setHeight((int)((15d / 100 * height)));
views.get("button2").vw.setWidth((int)((35d / 100 * width)));
views.get("button2").vw.setLeft((int)((60d / 100 * width)));
views.get("button1").vw.setTop((int)((views.get("label2").vw.getTop())+(views.get("label2").vw.getHeight())+(5d / 100 * height)));
views.get("button1").vw.setWidth((int)((35d / 100 * width)));
views.get("button1").vw.setHeight((int)((15d / 100 * height)));
views.get("button1").vw.setLeft((int)((5d / 100 * width)));
views.get("edittext1").vw.setTop((int)((views.get("label3").vw.getTop())+(views.get("label3").vw.getHeight())+(5d / 100 * height)));
views.get("edittext1").vw.setHeight((int)((20d / 100 * height)));
views.get("edittext1").vw.setWidth((int)((55d / 100 * width)));
views.get("edittext1").vw.setLeft((int)((2.5d / 100 * width)));
views.get("edittext2").vw.setTop((int)((views.get("edittext1").vw.getTop())+(views.get("edittext1").vw.getHeight())+(5d / 100 * height)));
views.get("edittext2").vw.setHeight((int)((20d / 100 * height)));
views.get("edittext2").vw.setWidth((int)((55d / 100 * width)));
views.get("edittext2").vw.setLeft((int)((2.5d / 100 * width)));

}
}