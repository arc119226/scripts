static main(args) {

	def lists = [
		//'127.0.0.1',
		// '172.20.111.171','172.20.101.17','172.20.111.174',//sit
		// '172.20.111.179','172.20.111.182','172.20.111.183',//prod
		// '172.31.0.147','172.31.0.148',//1001
		// '172.31.1.129','172.31.1.130',//1003
		// '172.22.1.14','172.22.1.15',//2001
		// '172.22.2.9','172.22.2.10',//2002
		// '172.22.3.13','172.22.3.14',//2003
		'172.22.5.14','172.22.5.15',//2005
	// 	'172.22.6.13','172.22.6.14',//2006
	// 	'172.22.8.13','172.22.8.14',//2008
	// 	'172.24.0.1','172.24.0.4',//a
	// 	'172.24.0.2','172.24.0.5',//b
	// 	'172.24.0.3','172.24.0.6',//c
	// 	'172.22.10.13','172.22.10.14',//2010
	// 	'172.22.11.1','172.22.11.2',//2011
	// 	'172.22.12.2','172.22.12.3',//2012
	// 	'172.22.13.2','172.22.13.3',//2013
	// 	'172.22.15.1','172.22.15.2',//2015
	// 	"172.22.16.13","172.22.16.14",//2016
	// 	"172.22.17.14","172.22.17.15",//2017
	// 	"172.22.18.1","172.22.18.2",//2018
	]

	lists.each{it->
		def CONSOL_IP=it
		String jsonText = new URL("http://${CONSOL_IP}:8500/v1/health/state/critical").text
		// println jsonText
		def jsonSlurper = new groovy.json.JsonSlurper()
		def object = jsonSlurper.parseText(jsonText)
		object.each{data->
			println CONSOL_IP +" " + data.ServiceID
  
			def process = "curl -XPUT http://$CONSOL_IP:8500/v1/agent/service/deregister/$data.ServiceID".execute()
			process.waitFor()

			println "Exit value: ${process.exitValue()}"
			println "Standard output: ${process.in.text}"
			println "Error output: ${process.err.text}"

		}
		sleep(500)
		println it
	}

}