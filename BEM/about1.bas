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
	
End Sub

Sub Globals
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
Activity.LoadLayout("about")

	
For Each view1 As View In Activity.getallviewsrecursive
If view1 Is Label Then
Dim Label1 As Label
Label1 = view1
Label1.typeface = Typeface.loadfromassets("yekan.ttf")
Label1.TextColor=Colors.White

End If
Next

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean
  If KeyCode = KeyCodes.KEYCODE_BACK Then 
  	 
	  StartActivity(main2)
        Activity.Finish                                         
  End If
  
End Sub

