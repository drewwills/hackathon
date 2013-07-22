/*
 * Import properties & report
 */
Properties props = new Properties();
props.load(new FileReader('hackathon.properties'));
println '## USING PROPERTIES ##';
props.each { k, v ->
	println "  $k=$v";
}
println '';

return props;