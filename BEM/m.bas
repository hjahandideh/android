Type=Activity
Version=5.02
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	Dim sq As SQL
End Sub

Sub Globals
	Dim c1 As Cursor
	Private ImageView1 As ImageView
	Private ImageView2 As ImageView
	Private Label1 As Label
	Private Label2 As Label
	Private Label3 As Label
	Private Label4 As Label
	Private Panel1 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("f")
	If File.Exists(File.DirInternal,"bemdb.db") = False Then
		File.Copy(File.DirAssets,"bemdb.db",File.DirInternal,"bemdb.db")
	Else
		ToastMessageShow("E",False)
	End If
	sq.Initialize(File.DirInternal,"bemdb.db",False)

	c1 = sq.ExecQuery("SELECT * FROM bem")
		

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


