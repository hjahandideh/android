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
	Private EditText3 As EditText
	Private EditText4 As EditText
	Dim c1 As Cursor
End Sub

Sub Activity_Create(FirstTime As Boolean)
	
Activity.LoadLayout("vorood")

		
For Each view1 As View In Activity.getallviewsrecursive
If view1 Is Label Then
Dim Label1 As Label
Label1 = view1
Label1.typeface = Typeface.loadfromassets("yekan.ttf")
Label1.TextColor=Colors.White
End If
Next

If File.exists(File.dirinternal,"bemdb.db") = True Then
		File.copy(File.dirassets,"bemdb.db",File.dirinternal,"bemdb.db")
	End If
		sq.Initialize(File.DirInternal,"bemdb.db",False)
ht.Initialize("Register",Me)
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub JobDone (job As HttpJob)

	If job.Success=True Then
		
		If job.JobName="Register" Then
			
			ProgressDialogHide
			Msgbox(job.GetString,"Come")
			
		End If
	
	Else 
		ToastMessageShow("Error During Connecting",False)
	End If
	
End Sub


Sub Button1_Click
Dim go As String 
	go = "&name="&EditText1.Text&"&fname="&EditText2.Text&"&username="&EditText3.Text&"&pass="&EditText4.Text
	ht.PostString("http://bemq.ir/vorood.php",go)
	ProgressDialogShow("Please Wait ...")

End Sub
Sub Button2_Click
	 StartActivity(ozveyat)
	 Activity.Finish
End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean
  If KeyCode = KeyCodes.KEYCODE_BACK Then                          
      StartActivity(ozveyat)
         Activity.Finish                                         
  
   End If
End Sub