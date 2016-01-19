﻿Type=Activity
Version=5.02
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	Dim sq As SQL

	
End Sub

Sub Globals
	Dim sm As SlideMenu
	Private btnshow As Button
	Private EditText1 As EditText
	Dim clv2 As CustomListView
	Dim c1 As Cursor
	Private Panel1 As Panel
	
	Private Label1 As Label
	Private Label2 As Label
	Private Label3 As Label
	Private Label4 As Label
	
	Private Label7 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
		Activity.LoadLayout("d")
		
	
		
sm.Initialize(Activity,Me,"SlideMenu",42dip,180dip)

	  
	sm.AddItem("ورود",LoadBitmap(File.DirAssets,"s.png"),2)
	  sm.AddItem("درباره ما",LoadBitmap(File.DirAssets,"u.png"),3)
	  sm.AddItem("خروج",LoadBitmap(File.DirAssets,"d.jpg"),4)



		EditText1.Color=Colors.RGB(242,242,242)
		EditText1.TextColor=Colors.Black
      
	  
	  
If File.Exists(File.DirInternal,"bemdb.db") = False Then
File.Copy(File.DirAssets,"bemdb.db",File.DirInternal,"bemdb.db")
End If
If sq.IsInitialized = False Then
sq.Initialize(File.DirInternal, "bemdb.db", False)
End If
DBload("")


	
	
	

EditText1.TextColor=Colors.White

For Each view1 As View In Activity.getallviewsrecursive
If view1 Is Label Then
Dim Label1 As Label
Label1 = view1
Label1.typeface = Typeface.loadfromassets("yekan.ttf")
Label1.TextColor=Colors.Black

End If
Next	
	  
End Sub


Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
 Sub btnshow_click
 sm.Show
 End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean
  Dim  answ As Int
  If KeyCode = KeyCodes.KEYCODE_BACK Then                         
      answ=Msgbox2("آیا می خواهید خارج شوید","خروج از برنامه","بله","","خیر",Null)
             If answ=DialogResponse.POSITIVE Then
                
				Activity.Finish
				ExitApplication
				Main.n.Cancel(1)
                Else
            Return True
           End If                                            
   Else
      Return False
   End If
End Sub
Sub DBload(q As String)

Private condition As String
q=q.Trim
condition="WHERE name LIKE '%" & q & "%'"

	clv2.initialize(Me, "clv2")
 	Activity.addview(clv2.asview,0,20%y,100%x,80%y)
c1 = sq.ExecQuery("SELECT * FROM bem " & condition)

Dim p1 As Panel
	For i=0 To c1.RowCount-1
	p1.initialize("")
	p1.loadlayout("f")
	c1.Position = i
	Label1.text="حرفه:"&c1.getstring("name")
		Label2.text="مدیریت:"&c1.getstring("fnam")
		Label3.text="تلفن:"&c1.getstring("tel")
		Label4.text="آدرس:"&c1.getstring("address")
		clv2.add(p1,30%y,i)
 		If i mod 2=0 Then
			Panel1.Color=Colors.RGB(70,130,80)
		Else
			Panel1.Color=Colors.RGB(176,196,222)
		End If
Next
For Each view1 As View In Activity.getallviewsrecursive
If view1 Is Label Then
Dim Label1 As Label
Label1 = view1
Label1.typeface = Typeface.loadfromassets("yekan.ttf")
Label1.TextColor=Colors.Black

End If
Next

End Sub


Sub EditText1_TextChanged (Old As String, New As String)
	DBload(New)
End Sub
