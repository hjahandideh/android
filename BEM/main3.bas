Type=Activity
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
Dim s As String
	
End Sub

Sub Globals

	Dim rowcount As Int
	Dim sm As SlideMenu
	Private btnshow As Button
	Private EditText1 As EditText
	Dim clv2 As CustomListView
	Dim c1 As Cursor
	Private Panel1 As Panel
	Dim ht,ht2 As HttpJob
	Private Label1 As Label
	Private Label2 As Label
	Private Label3 As Label
	Private Label4 As Label
	
	Private Label7 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
		Activity.LoadLayout("d")
			
		ht.Initialize("job1",Me)
	ht2.Initialize("job2",Me)


sm.Initialize(Activity,Me,"SlideMenu",42dip,180dip)

sm.AddItem("کاربر:"&s,LoadBitmap(File.DirAssets,"u.png"),0)
 sm.AddItem("ثبت شغل جدید",LoadBitmap(File.DirAssets,"a.jpg"),1)
	sm.AddItem("خروج کاربر",LoadBitmap(File.DirAssets,"s.png"),5)

	  sm.AddItem("درباره ما",LoadBitmap(File.DirAssets,"u.png"),6)
	  sm.AddItem("خروج",LoadBitmap(File.DirAssets,"d.jpg"),4)




		EditText1.Color=Colors.RGB(242,242,242)
		EditText1.TextColor=Colors.Black
      
	  
	  
If File.Exists(File.DirInternal,"bemdb.db") = False Then
File.Copy(File.DirAssets,"bemdb.db",File.DirInternal,"bemdb.db")
End If
If sq.IsInitialized = False Then
sq.Initialize(File.DirInternal, "bemdb.db", False)
End If


ht.PostString("http://bemq.ir/check.php","")
	


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

Sub jobdone (job As HttpJob)
	
	
	
	If job.Success = True Then
		If job.JobName = "job1" Then
			
					c1 = sq.ExecQuery("SELECT * FROM bem")
					rowcount = c1.RowCount
					
					If job.GetString > rowcount Then
						
					
					
						c1 = sq.ExecQuery("SELECT * FROM bem")
						rowcount = c1.RowCount
						
						ht2.PostString("http://bemq.ir/getcontent.php","tedad="& rowcount &"")
						
						
						
					Else
					DBload("")
						
					End If
					
		else if job.JobName = "job2" Then
					If job.GetString = "nothing" Then
						ToastMessageShow("error",False)
					
					Else 
				
					
						Dim str1() As String = Regex.Split("<br>",job.GetString)
						For i = 0 To str1.Length-1
							Dim str2() As String = Regex.Split("#",str1(i))
							
								sq.ExecNonQuery("INSERT INTO bem (id,name,fnam,tel,address) VALUES (null,'"&str2(1)&"','"&str2(2)&"','"&str2(3)&"','"&str2(4)&"')")
								DBload("")
							
						Next
					ProgressDialogHide
					End If
		End If
		
	
	End If
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
                Main.n.Cancel(1)
				Activity.Finish
				ExitApplication
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
