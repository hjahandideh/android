package bem.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_vorood{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("imageview1").vw.setLeft((int)(0d));
views.get("imageview1").vw.setTop((int)(0d));
views.get("imageview1").vw.setWidth((int)((100d / 100 * width)));
views.get("imageview1").vw.setHeight((int)((100d / 100 * height)));
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
views.get("button1").vw.setTop((int)((views.get("label5").vw.getTop())+(3d / 100 * height)+(views.get("label5").vw.getHeight())));
views.get("button1").vw.setWidth((int)((35d / 100 * width)));
views.get("button1").vw.setHeight((int)((10d / 100 * height)));
views.get("button1").vw.setLeft((int)((5d / 100 * width)));
views.get("button2").vw.setTop((int)((views.get("label5").vw.getTop())+(3d / 100 * height)+(views.get("label5").vw.getHeight())));
views.get("button2").vw.setHeight((int)((10d / 100 * height)));
views.get("button2").vw.setWidth((int)((35d / 100 * width)));
views.get("button2").vw.setLeft((int)((60d / 100 * width)));
views.get("edittext1").vw.setTop((int)((views.get("label1").vw.getTop())+(1d / 100 * height)+(views.get("label1").vw.getHeight())));
views.get("edittext1").vw.setHeight((int)((12d / 100 * height)));
views.get("edittext1").vw.setLeft((int)((2d / 100 * width)));
views.get("edittext1").vw.setWidth((int)((68d / 100 * width)));
views.get("edittext2").vw.setTop((int)((views.get("edittext1").vw.getTop())+(5d / 100 * height)+(views.get("edittext1").vw.getHeight())));
views.get("edittext2").vw.setHeight((int)((12d / 100 * height)));
views.get("edittext2").vw.setLeft((int)((2d / 100 * width)));
views.get("edittext2").vw.setWidth((int)((68d / 100 * width)));
views.get("edittext3").vw.setTop((int)((views.get("edittext2").vw.getTop())+(5d / 100 * height)+(views.get("edittext2").vw.getHeight())));
views.get("edittext3").vw.setHeight((int)((12d / 100 * height)));
views.get("edittext3").vw.setLeft((int)((2d / 100 * width)));
views.get("edittext3").vw.setWidth((int)((68d / 100 * width)));
views.get("edittext4").vw.setTop((int)((views.get("edittext3").vw.getTop())+(5d / 100 * height)+(views.get("edittext3").vw.getHeight())));
views.get("edittext4").vw.setHeight((int)((12d / 100 * height)));
views.get("edittext4").vw.setLeft((int)((2d / 100 * width)));
views.get("edittext4").vw.setWidth((int)((68d / 100 * width)));

}
}