package bem.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_f{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("panel1").vw.setTop((int)((1d / 100 * height)));
views.get("panel1").vw.setLeft((int)((1d / 100 * width)));
views.get("panel1").vw.setWidth((int)((98d / 100 * width)));
views.get("panel1").vw.setHeight((int)((35d / 100 * height)));
views.get("label1").vw.setTop((int)((1d / 100 * height)));
views.get("label1").vw.setLeft((int)((60d / 100 * width)));
views.get("label1").vw.setWidth((int)((40d / 100 * width)));
views.get("label1").vw.setHeight((int)((10d / 100 * height)));
views.get("label5").vw.setTop((int)((views.get("label1").vw.getTop())+(views.get("label1").vw.getHeight())+(1d / 100 * height)));
views.get("label5").vw.setLeft((int)((1d / 100 * width)));
views.get("label5").vw.setWidth((int)((98d / 100 * width)));
views.get("label5").vw.setHeight((int)((3d / 100 * height)));
views.get("label3").vw.setTop((int)((17d / 100 * height)));
views.get("label3").vw.setLeft((int)((60d / 100 * width)));
views.get("label3").vw.setWidth((int)((40d / 100 * width)));
views.get("label3").vw.setHeight((int)((10d / 100 * height)));
views.get("label2").vw.setTop((int)((1d / 100 * height)));
views.get("label2").vw.setLeft((int)((1d / 100 * width)));
views.get("label2").vw.setWidth((int)((58d / 100 * width)));
views.get("label2").vw.setHeight((int)((10d / 100 * height)));
views.get("label4").vw.setTop((int)((17d / 100 * height)));
views.get("label4").vw.setLeft((int)((1d / 100 * width)));
views.get("label4").vw.setHeight((int)((10d / 100 * height)));
views.get("label4").vw.setWidth((int)((58d / 100 * width)));

}
}