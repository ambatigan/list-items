def props = new Properties()
def stream = new FileInputStream("items_list.txt")
try {
props.load(stream)
} finally {
stream.close()
}
def parameters=props.keySet() as String[];
parameters= parameters.sort { it.size() }
def var = Arrays.asList(parameters)
System.out.println(var)
return var
