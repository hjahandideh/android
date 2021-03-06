package bem.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class slidemenu extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "bem.com.slidemenu");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            if (BA.isShellModeRuntimeCheck(ba)) {
			    ba.raiseEvent2(null, true, "CREATE", true, "bem.com.slidemenu",
                    ba);
                return;
		    }
        }
        ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.phone.Phone.PhoneIntents _i1 = null;
public anywheresoftware.b4a.phone.Phone.Email _message = null;
public anywheresoftware.b4a.objects.PanelWrapper _mslidepanel = null;
public anywheresoftware.b4a.objects.PanelWrapper _mbackpanel = null;
public Object _mmodule = null;
public String _meventname = "";
public anywheresoftware.b4a.objects.ListViewWrapper _mlistview = null;
public anywheresoftware.b4a.objects.AnimationWrapper _minanimation = null;
public anywheresoftware.b4a.objects.AnimationWrapper _moutanimation = null;
public b4a.example.scond _scond = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public bem.com.main _main = null;
public bem.com.about _about = null;
public bem.com.sbank _sbank = null;
public bem.com.main3 _main3 = null;
public bem.com.vorood _vorood = null;
public bem.com.ozveyat _ozveyat = null;
public bem.com.main2 _main2 = null;
public bem.com.about1 _about1 = null;
public static class _actionitem{
public boolean IsInitialized;
public String Text;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper Image;
public Object Value;
public void Initialize() {
IsInitialized = true;
Text = "";
Image = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
Value = new Object();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _additem(String _text,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _image,Object _returnvalue) throws Exception{
bem.com.slidemenu._actionitem _item = null;
 //BA.debugLineNum = 63;BA.debugLine="Public Sub AddItem(Text As String, Image As Bitmap";
 //BA.debugLineNum = 64;BA.debugLine="Dim item As ActionItem";
_item = new bem.com.slidemenu._actionitem();
 //BA.debugLineNum = 65;BA.debugLine="item.Initialize";
_item.Initialize();
 //BA.debugLineNum = 66;BA.debugLine="item.Text = Text";
_item.Text = _text;
 //BA.debugLineNum = 67;BA.debugLine="item.Image = Image";
_item.Image = _image;
 //BA.debugLineNum = 68;BA.debugLine="item.Value = ReturnValue";
_item.Value = _returnvalue;
 //BA.debugLineNum = 70;BA.debugLine="If Not(Image.IsInitialized) Then";
if (__c.Not(_image.IsInitialized())) { 
 //BA.debugLineNum = 71;BA.debugLine="mListView.AddTwoLinesAndBitmap2(Text, \"\", Null,";
_mlistview.AddTwoLinesAndBitmap2(_text,"",(android.graphics.Bitmap)(__c.Null),_returnvalue);
 }else {
 //BA.debugLineNum = 73;BA.debugLine="mListView.AddTwoLinesAndBitmap2(Text, \"\", Image,";
_mlistview.AddTwoLinesAndBitmap2(_text,"",(android.graphics.Bitmap)(_image.getObject()),_returnvalue);
 };
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Type ActionItem (Text As String, Image As Bitmap,";
;
 //BA.debugLineNum = 9;BA.debugLine="Dim i1 As PhoneIntents";
_i1 = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
 //BA.debugLineNum = 10;BA.debugLine="Dim Message As Email";
_message = new anywheresoftware.b4a.phone.Phone.Email();
 //BA.debugLineNum = 12;BA.debugLine="Private mSlidePanel As Panel";
_mslidepanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private mBackPanel As Panel";
_mbackpanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private mModule As Object";
_mmodule = new Object();
 //BA.debugLineNum = 16;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 18;BA.debugLine="Private mListView As ListView";
_mlistview = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private mInAnimation As Animation";
_minanimation = new anywheresoftware.b4a.objects.AnimationWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private mOutAnimation As Animation";
_moutanimation = new anywheresoftware.b4a.objects.AnimationWrapper();
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public String  _hide() throws Exception{
 //BA.debugLineNum = 91;BA.debugLine="Public Sub Hide";
 //BA.debugLineNum = 92;BA.debugLine="If isVisible = False Then Return";
if (_isvisible()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 94;BA.debugLine="mBackPanel.Left = -mBackPanel.Width";
_mbackpanel.setLeft((int) (-_mbackpanel.getWidth()));
 //BA.debugLineNum = 95;BA.debugLine="mSlidePanel.Left = -mSlidePanel.Width";
_mslidepanel.setLeft((int) (-_mslidepanel.getWidth()));
 //BA.debugLineNum = 96;BA.debugLine="mOutAnimation.Start(mSlidePanel)";
_moutanimation.Start((android.view.View)(_mslidepanel.getObject()));
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,Object _module,String _eventname,int _top,int _width) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 31;BA.debugLine="Sub Initialize(Activity As Activity, Module As Obj";
 //BA.debugLineNum = 32;BA.debugLine="mModule = Module";
_mmodule = _module;
 //BA.debugLineNum = 33;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 35;BA.debugLine="mSlidePanel.Initialize(\"mSlidePanel\")";
_mslidepanel.Initialize(ba,"mSlidePanel");
 //BA.debugLineNum = 36;BA.debugLine="mListView.Initialize(\"mListView\")";
_mlistview.Initialize(ba,"mListView");
 //BA.debugLineNum = 37;BA.debugLine="mListView.TwoLinesAndBitmap.SecondLabel.Visible =";
_mlistview.getTwoLinesAndBitmap().SecondLabel.setVisible(__c.False);
 //BA.debugLineNum = 38;BA.debugLine="mListView.TwoLinesAndBitmap.ItemHeight = 50dip";
_mlistview.getTwoLinesAndBitmap().setItemHeight(__c.DipToCurrent((int) (50)));
 //BA.debugLineNum = 39;BA.debugLine="mListView.TwoLinesAndBitmap.Label.Gravity = Gravi";
_mlistview.getTwoLinesAndBitmap().Label.setGravity(__c.Gravity.LEFT);
 //BA.debugLineNum = 40;BA.debugLine="mListView.TwoLinesAndBitmap.Label.Height = mListV";
_mlistview.getTwoLinesAndBitmap().Label.setHeight(_mlistview.getTwoLinesAndBitmap().getItemHeight());
 //BA.debugLineNum = 41;BA.debugLine="mListView.TwoLinesAndBitmap.Label.Top = 0";
_mlistview.getTwoLinesAndBitmap().Label.setTop((int) (0));
 //BA.debugLineNum = 42;BA.debugLine="mListView.TwoLinesAndBitmap.ImageView.SetLayout(1";
_mlistview.getTwoLinesAndBitmap().ImageView.SetLayout(__c.DipToCurrent((int) (13)),__c.DipToCurrent((int) (13)),__c.DipToCurrent((int) (24)),__c.DipToCurrent((int) (24)));
 //BA.debugLineNum = 43;BA.debugLine="mListView.Color = Colors.RGB(39, 153, 202)";
_mlistview.setColor(__c.Colors.RGB((int) (39),(int) (153),(int) (202)));
 //BA.debugLineNum = 44;BA.debugLine="mListView.TwoLinesAndBitmap.Label.Typeface=Type";
_mlistview.getTwoLinesAndBitmap().Label.setTypeface(__c.Typeface.LoadFromAssets("yekan.ttf"));
 //BA.debugLineNum = 45;BA.debugLine="mInAnimation.InitializeTranslate(\"\", -Width, 0, 0";
_minanimation.InitializeTranslate(ba,"",(float) (-_width),(float) (0),(float) (0),(float) (0));
 //BA.debugLineNum = 46;BA.debugLine="mInAnimation.Duration = 200";
_minanimation.setDuration((long) (200));
 //BA.debugLineNum = 47;BA.debugLine="mOutAnimation.InitializeTranslate(\"Out\", Width, 0";
_moutanimation.InitializeTranslate(ba,"Out",(float) (_width),(float) (0),(float) (0),(float) (0));
 //BA.debugLineNum = 48;BA.debugLine="mOutAnimation.Duration = 200";
_moutanimation.setDuration((long) (200));
 //BA.debugLineNum = 50;BA.debugLine="Activity.AddView(mSlidePanel, 0, Top, Width, 100%";
_activity.AddView((android.view.View)(_mslidepanel.getObject()),(int) (0),_top,_width,(int) (__c.PerYToCurrent((float) (100),ba)-_top));
 //BA.debugLineNum = 52;BA.debugLine="mBackPanel.Initialize(\"mBackPanel\")";
_mbackpanel.Initialize(ba,"mBackPanel");
 //BA.debugLineNum = 53;BA.debugLine="Activity.AddView(mBackPanel, -100%x, 0, 100%x, 50";
_activity.AddView((android.view.View)(_mbackpanel.getObject()),(int) (-__c.PerXToCurrent((float) (100),ba)),(int) (0),__c.PerXToCurrent((float) (100),ba),__c.PerYToCurrent((float) (50),ba));
 //BA.debugLineNum = 55;BA.debugLine="mSlidePanel.AddView(mListView, 0, 0, mSlidePanel.";
_mslidepanel.AddView((android.view.View)(_mlistview.getObject()),(int) (0),(int) (0),_mslidepanel.getWidth(),_mslidepanel.getHeight());
 //BA.debugLineNum = 56;BA.debugLine="mSlidePanel.Visible = False";
_mslidepanel.setVisible(__c.False);
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public boolean  _isvisible() throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Public Sub isVisible As Boolean";
 //BA.debugLineNum = 152;BA.debugLine="Return mSlidePanel.Visible";
if (true) return _mslidepanel.getVisible();
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return false;
}
public String  _mbackpanel_touch(int _action,float _x,float _y) throws Exception{
 //BA.debugLineNum = 103;BA.debugLine="Private Sub mBackPanel_Touch (Action As Int, X As";
 //BA.debugLineNum = 104;BA.debugLine="If Action = 1 Then";
if (_action==1) { 
 //BA.debugLineNum = 105;BA.debugLine="Hide";
_hide();
 };
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public String  _mlistview_itemclick(int _position,Object _value) throws Exception{
int _answ = 0;
 //BA.debugLineNum = 109;BA.debugLine="Private Sub mListView_ItemClick (Position As Int,";
 //BA.debugLineNum = 110;BA.debugLine="If Value=1 Then";
if ((_value).equals((Object)(1))) { 
 //BA.debugLineNum = 112;BA.debugLine="StartActivity(sbank)";
__c.StartActivity(ba,(Object)(_sbank.getObject()));
 //BA.debugLineNum = 113;BA.debugLine="ExitApplication";
__c.ExitApplication();
 };
 //BA.debugLineNum = 115;BA.debugLine="If Value=2 Then";
if ((_value).equals((Object)(2))) { 
 //BA.debugLineNum = 116;BA.debugLine="StartActivity(ozveyat)";
__c.StartActivity(ba,(Object)(_ozveyat.getObject()));
 //BA.debugLineNum = 117;BA.debugLine="ExitApplication";
__c.ExitApplication();
 };
 //BA.debugLineNum = 119;BA.debugLine="If Value=3 Then";
if ((_value).equals((Object)(3))) { 
 //BA.debugLineNum = 121;BA.debugLine="StartActivity(about1)";
__c.StartActivity(ba,(Object)(_about1.getObject()));
 //BA.debugLineNum = 122;BA.debugLine="ExitApplication";
__c.ExitApplication();
 };
 //BA.debugLineNum = 124;BA.debugLine="If Value=4 Then";
if ((_value).equals((Object)(4))) { 
 //BA.debugLineNum = 125;BA.debugLine="Dim  answ As Int";
_answ = 0;
 //BA.debugLineNum = 126;BA.debugLine="answ=Msgbox2(\"آیا می خواهید خارج شوید\",\"خروج";
_answ = __c.Msgbox2("آیا می خواهید خارج شوید","خروج از برنامه","بله","","خیر",(android.graphics.Bitmap)(__c.Null),ba);
 //BA.debugLineNum = 127;BA.debugLine="If answ=DialogResponse.POSITIVE Then";
if (_answ==__c.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 129;BA.debugLine="ExitApplication";
__c.ExitApplication();
 //BA.debugLineNum = 130;BA.debugLine="Main.n.Cancel(1)";
_main._n.Cancel((int) (1));
 }else {
 //BA.debugLineNum = 134;BA.debugLine="Hide";
_hide();
 };
 };
 //BA.debugLineNum = 137;BA.debugLine="If Value=5 Then";
if ((_value).equals((Object)(5))) { 
 //BA.debugLineNum = 139;BA.debugLine="StartActivity(main2)";
__c.StartActivity(ba,(Object)(_main2.getObject()));
 //BA.debugLineNum = 140;BA.debugLine="ExitApplication";
__c.ExitApplication();
 };
 //BA.debugLineNum = 143;BA.debugLine="If Value=6 Then";
if ((_value).equals((Object)(6))) { 
 //BA.debugLineNum = 145;BA.debugLine="StartActivity(about)";
__c.StartActivity(ba,(Object)(_about.getObject()));
 //BA.debugLineNum = 146;BA.debugLine="ExitApplication";
__c.ExitApplication();
 };
 //BA.debugLineNum = 148;BA.debugLine="End Sub";
return "";
}
public String  _out_animationend() throws Exception{
 //BA.debugLineNum = 99;BA.debugLine="Private Sub Out_AnimationEnd";
 //BA.debugLineNum = 100;BA.debugLine="mSlidePanel.Visible = False";
_mslidepanel.setVisible(__c.False);
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
public String  _show() throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Public Sub Show";
 //BA.debugLineNum = 79;BA.debugLine="If isVisible = True Then Return";
if (_isvisible()==__c.True) { 
if (true) return "";};
 //BA.debugLineNum = 81;BA.debugLine="mBackPanel.BringToFront";
_mbackpanel.BringToFront();
 //BA.debugLineNum = 82;BA.debugLine="mSlidePanel.BringToFront";
_mslidepanel.BringToFront();
 //BA.debugLineNum = 83;BA.debugLine="mBackPanel.Left = 0";
_mbackpanel.setLeft((int) (0));
 //BA.debugLineNum = 84;BA.debugLine="mSlidePanel.Left = 0";
_mslidepanel.setLeft((int) (0));
 //BA.debugLineNum = 86;BA.debugLine="mSlidePanel.Visible = True";
_mslidepanel.setVisible(__c.True);
 //BA.debugLineNum = 87;BA.debugLine="mInAnimation.Start(mSlidePanel)";
_minanimation.Start((android.view.View)(_mslidepanel.getObject()));
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
