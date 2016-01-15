package bem.com;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main3 extends Activity implements B4AActivity{
	public static main3 mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new BA(this.getApplicationContext(), null, null, "bem.com", "bem.com.main3");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main3).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
		BA.handler.postDelayed(new WaitForLayout(), 5);

	}
	private static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "bem.com", "bem.com.main3");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "bem.com.main3", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main3) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main3) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main3.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main3) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main3) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL _sq = null;
public static String _s = "";
public anywheresoftware.b4a.objects.NotificationWrapper _n = null;
public bem.com.slidemenu _sm = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnshow = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext1 = null;
public bem.com.customlistview _clv2 = null;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _c1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.samples.httputils2.httpjob _ht = null;
public anywheresoftware.b4a.samples.httputils2.httpjob _ht2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public static int _rowcount = 0;
public static int _t = 0;
public anywheresoftware.b4a.objects.LabelWrapper _label7 = null;
public b4a.example.scond _scond = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public bem.com.main _main = null;
public bem.com.about _about = null;
public bem.com.sbank _sbank = null;
public bem.com.vorood _vorood = null;
public bem.com.ozveyat _ozveyat = null;
public bem.com.main2 _main2 = null;
public bem.com.about1 _about1 = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.ConcreteViewWrapper _view1 = null;
 //BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"d\")";
mostCurrent._activity.LoadLayout("d",mostCurrent.activityBA);
 //BA.debugLineNum = 32;BA.debugLine="ht.Initialize(\"job1\",Me)";
mostCurrent._ht._initialize(processBA,"job1",main3.getObject());
 //BA.debugLineNum = 33;BA.debugLine="ht2.Initialize(\"job2\",Me)";
mostCurrent._ht2._initialize(processBA,"job2",main3.getObject());
 //BA.debugLineNum = 36;BA.debugLine="sm.Initialize(Activity,Me,\"SlideMenu\",42dip,180dip";
mostCurrent._sm._initialize(mostCurrent.activityBA,mostCurrent._activity,main3.getObject(),"SlideMenu",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (42)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (180)));
 //BA.debugLineNum = 38;BA.debugLine="sm.AddItem(\"کاربر:\"&s,LoadBitmap(File.DirAssets,\"u";
mostCurrent._sm._additem("کاربر:"+_s,anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"u.png"),(Object)(0));
 //BA.debugLineNum = 39;BA.debugLine="sm.AddItem(\"ثبت شغل جدید\",LoadBitmap(File.DirAsse";
mostCurrent._sm._additem("ثبت شغل جدید",anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"a.jpg"),(Object)(1));
 //BA.debugLineNum = 40;BA.debugLine="sm.AddItem(\"خروج کاربر\",LoadBitmap(File.DirAssets";
mostCurrent._sm._additem("خروج کاربر",anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"s.png"),(Object)(5));
 //BA.debugLineNum = 42;BA.debugLine="sm.AddItem(\"درباره ما\",LoadBitmap(File.DirAsset";
mostCurrent._sm._additem("درباره ما",anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"u.png"),(Object)(6));
 //BA.debugLineNum = 43;BA.debugLine="sm.AddItem(\"خروج\",LoadBitmap(File.DirAssets,\"d.";
mostCurrent._sm._additem("خروج",anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"d.jpg"),(Object)(4));
 //BA.debugLineNum = 48;BA.debugLine="EditText1.Color=Colors.RGB(242,242,242)";
mostCurrent._edittext1.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (242),(int) (242),(int) (242)));
 //BA.debugLineNum = 49;BA.debugLine="EditText1.TextColor=Colors.Black";
mostCurrent._edittext1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 53;BA.debugLine="If File.Exists(File.DirInternal,\"bemdb.db\") = Fals";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"bemdb.db")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 54;BA.debugLine="File.Copy(File.DirAssets,\"bemdb.db\",File.DirIntern";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"bemdb.db",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"bemdb.db");
 };
 //BA.debugLineNum = 56;BA.debugLine="If sq.IsInitialized = False Then";
if (_sq.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 57;BA.debugLine="sq.Initialize(File.DirInternal, \"bemdb.db\", False)";
_sq.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"bemdb.db",anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 61;BA.debugLine="ht.PostString(\"http://bemq.ir/check.php\",\"\")";
mostCurrent._ht._poststring("http://bemq.ir/check.php","");
 //BA.debugLineNum = 66;BA.debugLine="EditText1.TextColor=Colors.White";
mostCurrent._edittext1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 68;BA.debugLine="For Each view1 As View In Activity.getallviewsrecu";
_view1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
final anywheresoftware.b4a.BA.IterableList group40 = mostCurrent._activity.GetAllViewsRecursive();
final int groupLen40 = group40.getSize();
for (int index40 = 0;index40 < groupLen40 ;index40++){
_view1.setObject((android.view.View)(group40.Get(index40)));
 //BA.debugLineNum = 69;BA.debugLine="If view1 Is Label Then";
if (_view1.getObjectOrNull() instanceof android.widget.TextView) { 
 //BA.debugLineNum = 70;BA.debugLine="Dim Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 71;BA.debugLine="Label1 = view1";
mostCurrent._label1.setObject((android.widget.TextView)(_view1.getObject()));
 //BA.debugLineNum = 72;BA.debugLine="Label1.typeface = Typeface.loadfromassets(\"yekan.t";
mostCurrent._label1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets("yekan.ttf"));
 //BA.debugLineNum = 73;BA.debugLine="Label1.TextColor=Colors.Black";
mostCurrent._label1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
 }
;
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
int _answ = 0;
 //BA.debugLineNum = 135;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 136;BA.debugLine="Dim  answ As Int";
_answ = 0;
 //BA.debugLineNum = 137;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 138;BA.debugLine="answ=Msgbox2(\"آیا می خواهید خارج شوید\",\"خروج";
_answ = anywheresoftware.b4a.keywords.Common.Msgbox2("آیا می خواهید خارج شوید","خروج از برنامه","بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 139;BA.debugLine="If answ=DialogResponse.POSITIVE Then";
if (_answ==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 141;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 142;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 }else {
 //BA.debugLineNum = 144;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 }else {
 //BA.debugLineNum = 147;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public static String  _btnshow_click() throws Exception{
 //BA.debugLineNum = 132;BA.debugLine="Sub btnshow_click";
 //BA.debugLineNum = 133;BA.debugLine="sm.Show";
mostCurrent._sm._show();
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return "";
}
public static String  _dbload(String _q) throws Exception{
String _condition = "";
anywheresoftware.b4a.objects.PanelWrapper _p1 = null;
int _i = 0;
anywheresoftware.b4a.objects.ConcreteViewWrapper _view1 = null;
 //BA.debugLineNum = 150;BA.debugLine="Sub DBload(q As String)";
 //BA.debugLineNum = 152;BA.debugLine="Private condition As String";
_condition = "";
 //BA.debugLineNum = 153;BA.debugLine="q=q.Trim";
_q = _q.trim();
 //BA.debugLineNum = 154;BA.debugLine="condition=\"WHERE name LIKE '%\" & q & \"%'\"";
_condition = "WHERE name LIKE '%"+_q+"%'";
 //BA.debugLineNum = 156;BA.debugLine="clv2.initialize(Me, \"clv2\")";
mostCurrent._clv2._initialize(mostCurrent.activityBA,main3.getObject(),"clv2");
 //BA.debugLineNum = 157;BA.debugLine="Activity.addview(clv2.asview,0,20%y,100%x,80%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._clv2._asview().getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (80),mostCurrent.activityBA));
 //BA.debugLineNum = 158;BA.debugLine="c1 = sq.ExecQuery(\"SELECT * FROM bem \" & condition";
mostCurrent._c1.setObject((android.database.Cursor)(_sq.ExecQuery("SELECT * FROM bem "+_condition)));
 //BA.debugLineNum = 160;BA.debugLine="Dim p1 As Panel";
_p1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 161;BA.debugLine="For i=0 To c1.RowCount-1";
{
final int step105 = 1;
final int limit105 = (int) (mostCurrent._c1.getRowCount()-1);
for (_i = (int) (0); (step105 > 0 && _i <= limit105) || (step105 < 0 && _i >= limit105); _i = ((int)(0 + _i + step105))) {
 //BA.debugLineNum = 162;BA.debugLine="p1.initialize(\"\")";
_p1.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 163;BA.debugLine="p1.loadlayout(\"f\")";
_p1.LoadLayout("f",mostCurrent.activityBA);
 //BA.debugLineNum = 164;BA.debugLine="c1.Position = i";
mostCurrent._c1.setPosition(_i);
 //BA.debugLineNum = 165;BA.debugLine="Label1.text=\"حرفه:\"&c1.getstring(\"name\")";
mostCurrent._label1.setText((Object)("حرفه:"+mostCurrent._c1.GetString("name")));
 //BA.debugLineNum = 166;BA.debugLine="Label2.text=\"مدیریت:\"&c1.getstring(\"fnam\")";
mostCurrent._label2.setText((Object)("مدیریت:"+mostCurrent._c1.GetString("fnam")));
 //BA.debugLineNum = 167;BA.debugLine="Label3.text=\"تلفن:\"&c1.getstring(\"tel\")";
mostCurrent._label3.setText((Object)("تلفن:"+mostCurrent._c1.GetString("tel")));
 //BA.debugLineNum = 168;BA.debugLine="Label4.text=\"آدرس:\"&c1.getstring(\"address\")";
mostCurrent._label4.setText((Object)("آدرس:"+mostCurrent._c1.GetString("address")));
 //BA.debugLineNum = 169;BA.debugLine="clv2.add(p1,30%y,i)";
mostCurrent._clv2._add(_p1,anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (30),mostCurrent.activityBA),(Object)(_i));
 //BA.debugLineNum = 170;BA.debugLine="If i mod 2=0 Then";
if (_i%2==0) { 
 //BA.debugLineNum = 171;BA.debugLine="Panel1.Color=Colors.LightGray";
mostCurrent._panel1.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
 }else {
 //BA.debugLineNum = 173;BA.debugLine="Panel1.Color=Colors.White";
mostCurrent._panel1.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 };
 }
};
 //BA.debugLineNum = 176;BA.debugLine="For Each view1 As View In Activity.getallviewsrecu";
_view1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
final anywheresoftware.b4a.BA.IterableList group120 = mostCurrent._activity.GetAllViewsRecursive();
final int groupLen120 = group120.getSize();
for (int index120 = 0;index120 < groupLen120 ;index120++){
_view1.setObject((android.view.View)(group120.Get(index120)));
 //BA.debugLineNum = 177;BA.debugLine="If view1 Is Label Then";
if (_view1.getObjectOrNull() instanceof android.widget.TextView) { 
 //BA.debugLineNum = 178;BA.debugLine="Dim Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 179;BA.debugLine="Label1 = view1";
mostCurrent._label1.setObject((android.widget.TextView)(_view1.getObject()));
 //BA.debugLineNum = 180;BA.debugLine="Label1.typeface = Typeface.loadfromassets(\"yekan.t";
mostCurrent._label1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets("yekan.ttf"));
 //BA.debugLineNum = 181;BA.debugLine="Label1.TextColor=Colors.Black";
mostCurrent._label1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 };
 }
;
 //BA.debugLineNum = 186;BA.debugLine="End Sub";
return "";
}
public static String  _edittext1_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 189;BA.debugLine="Sub EditText1_TextChanged (Old As String, New As S";
 //BA.debugLineNum = 190;BA.debugLine="DBload(New)";
_dbload(_new);
 //BA.debugLineNum = 191;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Dim n As Notification";
mostCurrent._n = new anywheresoftware.b4a.objects.NotificationWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Dim sm As SlideMenu";
mostCurrent._sm = new bem.com.slidemenu();
 //BA.debugLineNum = 15;BA.debugLine="Private btnshow As Button";
mostCurrent._btnshow = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private EditText1 As EditText";
mostCurrent._edittext1 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Dim clv2 As CustomListView";
mostCurrent._clv2 = new bem.com.customlistview();
 //BA.debugLineNum = 18;BA.debugLine="Dim c1 As Cursor";
mostCurrent._c1 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Dim ht,ht2 As HttpJob";
mostCurrent._ht = new anywheresoftware.b4a.samples.httputils2.httpjob();
mostCurrent._ht2 = new anywheresoftware.b4a.samples.httputils2.httpjob();
 //BA.debugLineNum = 21;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private Label3 As Label";
mostCurrent._label3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private Label4 As Label";
mostCurrent._label4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Dim rowcount,t As Int";
_rowcount = 0;
_t = 0;
 //BA.debugLineNum = 26;BA.debugLine="Private Label7 As Label";
mostCurrent._label7 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
String[] _str1 = null;
int _i = 0;
String[] _str2 = null;
 //BA.debugLineNum = 80;BA.debugLine="Sub jobdone (job As HttpJob)";
 //BA.debugLineNum = 84;BA.debugLine="If job.Success = True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 85;BA.debugLine="If job.JobName = \"job1\" Then";
if ((_job._jobname).equals("job1")) { 
 //BA.debugLineNum = 87;BA.debugLine="c1 = sq.ExecQuery(\"SELECT * FROM bem\")";
mostCurrent._c1.setObject((android.database.Cursor)(_sq.ExecQuery("SELECT * FROM bem")));
 //BA.debugLineNum = 88;BA.debugLine="rowcount = c1.RowCount";
_rowcount = mostCurrent._c1.getRowCount();
 //BA.debugLineNum = 90;BA.debugLine="If job.GetString > rowcount Then";
if ((double)(Double.parseDouble(_job._getstring()))>_rowcount) { 
 //BA.debugLineNum = 92;BA.debugLine="c1 = sq.ExecQuery(\"SELECT * FROM bem\")";
mostCurrent._c1.setObject((android.database.Cursor)(_sq.ExecQuery("SELECT * FROM bem")));
 //BA.debugLineNum = 93;BA.debugLine="rowcount = c1.RowCount";
_rowcount = mostCurrent._c1.getRowCount();
 //BA.debugLineNum = 95;BA.debugLine="ht2.PostString(\"http://bemq.ir/getcontent.ph";
mostCurrent._ht2._poststring("http://bemq.ir/getcontent.php","tedad="+BA.NumberToString(_rowcount)+"");
 }else {
 //BA.debugLineNum = 99;BA.debugLine="DBload(\"\")";
_dbload("");
 };
 }else if((_job._jobname).equals("job2")) { 
 //BA.debugLineNum = 104;BA.debugLine="If job.GetString = \"nothing\" Then";
if ((_job._getstring()).equals("nothing")) { 
 //BA.debugLineNum = 105;BA.debugLine="ToastMessageShow(\"error\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("error",anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 110;BA.debugLine="Dim str1() As String = Regex.Split(\"<br>\",jo";
_str1 = anywheresoftware.b4a.keywords.Common.Regex.Split("<br>",_job._getstring());
 //BA.debugLineNum = 111;BA.debugLine="For i = 0 To str1.Length-1";
{
final int step66 = 1;
final int limit66 = (int) (_str1.length-1);
for (_i = (int) (0); (step66 > 0 && _i <= limit66) || (step66 < 0 && _i >= limit66); _i = ((int)(0 + _i + step66))) {
 //BA.debugLineNum = 112;BA.debugLine="Dim str2() As String = Regex.Split(\"#\",str1";
_str2 = anywheresoftware.b4a.keywords.Common.Regex.Split("#",_str1[_i]);
 //BA.debugLineNum = 114;BA.debugLine="sq.ExecNonQuery(\"INSERT INTO bem (id,name,";
_sq.ExecNonQuery("INSERT INTO bem (id,name,fnam,tel,address) VALUES (null,'"+_str2[(int) (1)]+"','"+_str2[(int) (2)]+"','"+_str2[(int) (3)]+"','"+_str2[(int) (4)]+"')");
 //BA.debugLineNum = 115;BA.debugLine="DBload(\"\")";
_dbload("");
 }
};
 //BA.debugLineNum = 118;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 };
 };
 };
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Dim sq As SQL";
_sq = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 8;BA.debugLine="Dim s As String";
_s = "";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
