def api='https://poloniex.com/public?command=returnTicker'
def text=new URL(api).text
def jsonSlurper = new groovy.json.JsonSlurper()
def object = jsonSlurper.parseText(text) 
object.keySet().each(){
	def result= 
	"""
		${it.split('_')[1]} to ${it.split('_')[0]} => ${object[it].last} <br>
	"""
	println result
}
