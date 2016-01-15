package bem.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_d{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("fakeactionbar").vw.setTop((int)(0d));
views.get("fakeactionbar").vw.setWidth((int)((100d / 100 * width)));
views.get("fakeactionbar").vw.setHeight((int)((8d / 100 * height)));
views.get("label7").vw.setTop((int)((1d / 100 * width)));
views.get("label7").vw.setWidth((int)((70d / 100 * width)));
views.get("label7").vw.setLeft((int)((30d / 100 * width)));
views.get("label7").vw.setHeight((int)((7d / 100 * height)));

}
}