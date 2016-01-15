package bem.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_main{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("imageview1").vw.setTop((int)(0d));
views.get("imageview1").vw.setLeft((int)(0d));
views.get("imageview1").vw.setWidth((int)((100d / 100 * width)));
views.get("imageview1").vw.setHeight((int)((100d / 100 * height)));
views.get("label1").vw.setTop((int)((18d / 100 * width)));
views.get("label1").vw.setHeight((int)((10d / 100 * height)));
views.get("label2").vw.setTop((int)((views.get("label1").vw.getTop())+(views.get("label1").vw.getHeight())+(6d / 100 * height)));
views.get("label2").vw.setLeft((int)((35d / 100 * width)));
views.get("label2").vw.setHeight((int)((10d / 100 * height)));
views.get("label2").vw.setWidth((int)((45d / 100 * width)));
views.get("label3").vw.setLeft((int)((27.5d / 100 * width)));
views.get("label3").vw.setHeight((int)((10d / 100 * height)));
views.get("label3").vw.setWidth((int)((50d / 100 * width)));
views.get("label3").vw.setTop((int)((views.get("label2").vw.getTop())+(views.get("label2").vw.getHeight())+(34.5d / 100 * height)));
views.get("label4").vw.setTop((int)((views.get("label3").vw.getTop())+(views.get("label3").vw.getHeight())+(1d / 100 * height)));
views.get("label4").vw.setLeft((int)((15d / 100 * width)));
views.get("label4").vw.setWidth((int)((70d / 100 * width)));
views.get("label4").vw.setHeight((int)((10d / 100 * height)));

}
}