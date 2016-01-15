Type=Activity
Version=5.02
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@


#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: false
#End Region

Sub Process_Globals
	Dim sq As SQL
End Sub

Sub Globals
	
	Dim ht As HttpJob
	

	Private Button1 As Button
	Private Button2 As Button
	Private EditText1 As EditText
	Private EditText2 As EditText
	Private Label1 As Label
	Private Label2 As Label
	Dim c2 As Cursor
End Sub

Sub Activity_Create(FirstTime As Boolean)

	Activity.LoadLayout("ozveyat")
	
For Each view1 As View In Activity.getallviewsrecursive
If view1 Is Label Then
Dim Label1 As Label
Label1 = view1
Label1.typeface = Typeface.loadfromassets("yekan.ttf")
Label1.TextColor=Colors.Black
End If
Next	

If File.Exists(File.DirInternal,"bemdb.db") = False Then
File.Copy(File.DirAssets,"bemdb.db",File.DirInternal,"bemdb.db")
End If
If sq.IsInitialized = False Then
sq.Initialize(File.DirInternal, "bemdb.db", False)
ht.Initialize("Register",Me)
End If
	
End Sub
Sub JobDone (job As HttpJob)

	If job.Success=True Then
		
		If job.JobName="Register" Then
			EditText1.Text=""
			EditText2.Text=""
			StartActivity(main3)
			
			Activity.Finish
				
		End If
	
	Else 
		ToastMessageShow("Error ",False)
	End If
	
End Sub
Sub Button1_click
Dim go As String
go = "&username="&EditText1.Text&"&pass="&EditText2.Text
	ht.PostString("http://bemq.ir/read_vorood.php",go)

main3.s=EditText1.Text

End Sub


Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
Sub Button2_click
StartActivity("vorood")
Activity.Finish
End Sub