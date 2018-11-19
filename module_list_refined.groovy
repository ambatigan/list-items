String output = new StringWriter().with { out ->
    Process proc = 'aws codecommit get-file --repository-name Testing-Automation --file-path /Jenkins/Dev/Resources/Input_data/tag_names.txt'.execute()|'jq -r .fileContent'.execute()|'base64 -d'.execute()
    proc.consumeProcessOutput( out, System.err )
    proc.waitFor()
    out.toString()
}
String[] str= output.split('\n')
def var = Arrays.asList(str)
return var
