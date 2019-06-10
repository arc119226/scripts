@Grab(group='commons-net', module='commons-net', version='2.0')
import org.apache.commons.net.ftp.FTPClient

println("About to connect....");
new FTPClient().with {
    connect("52.230.86.19",2188)
    enterLocalPassiveMode()
    login("userimage", "jcej0j;3!@#")
    changeWorkingDirectory("/home/ftp-docs/")
    File incomingFile = new File("index.html")

    disconnect()
}
println("...Done.");