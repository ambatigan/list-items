def command = '''
//for the aws codecommit repo
//aws codecommit get-file --repository-name Testing-Automation --file-path /Jenkins/Dev/Resources/Input_data/tag_names.txt|jq -r '.fileContent'|base64 -d > /tmp/tag_names_out.txt
//for the github repo
svn export https://github.com/ambatigan/list-items.git/trunk/items_list.txt --force && cp items_list.txt /tmp/tag_names_out.txt
'''
def proc = ['bash', '-c', command].execute()
proc.waitForOrKill(5000)
def props = new Properties()
def stream = new FileInputStream("/tmp/tag_names_out.txt")
try {
props.load(stream)
} finally {
stream.close()
}
def output =props.keySet() as String[];
output= output.sort { it.size() }
def var = Arrays.asList(output)
System.out.println(var)
return var
