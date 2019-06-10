new File("geo.conf").eachLine { line ->
	println 'deny '+line.trim().replace(' CN','').trim()
}