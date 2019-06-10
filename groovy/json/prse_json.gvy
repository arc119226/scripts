new File("newspend01.txt").eachLine { line ->
	def arr= line.split(",")
	def text=new URL("http://localhost/happycode/JointApi/getTotalChargeByUserIdJSON?userId=${arr[2]}").text
	def jsonSlurper = new groovy.json.JsonSlurper()
	def object = jsonSlurper.parseText(text)
	println line+','+object.totalSpend+','+object.date_created+','+object.reward+','+(arr[11]==object.reward?'':'*')
}