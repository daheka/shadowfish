# Shadowfish Master Branch
Setup mysql with database and edit credentials in application.yml:
username: username for connection to database
password: password for connection to database
url: jdbc:mysql://localhost:3306/name_of_database

Example settings.xml located in .m2/settings.xml:

<!-- NOTE: MAKE SURE THAT settings.xml IS NOT WORLD READABLE! -->
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                              https://maven.apache.org/xsd/settings-1.0.0.xsd">
<localRepository/>
<interactiveMode/>
<usePluginRegistry/>
<offline/>
<pluginGroups/>
    <servers>
        <server>
            <id>github</id>
            <username>Your_Username_in_github</username>
            <password>Your_Password_in_github</password>
        </server>
    </servers>
<mirrors/>
<proxies/>
    <profiles>
        <profile>
            <repositories>
                <repository>
                    <id>maven2</id>
                    <name>Maven 2 repo</name>
                    <releases>
                        <enabled>true</enabled>
                        <updatePolicy>always</updatePolicy>
                        <checksumPolicy>warn</checksumPolicy>
                    </releases>
                    <snapshots>
                        <enabled>false</enabled>
                        <updatePolicy>never</updatePolicy>
                        <checksumPolicy>fail</checksumPolicy>
                    </snapshots>
                    <url>http://repo.maven.org/maven2</url>
                    <layout>default</layout>
                </repository>
                <repository>
                    <id>shadowfish-mvn-repo</id>
                    <url>https://raw.github.com/daheka/shadowfish/mvn-repo/</url>
                    <snapshots>
                    <enabled>true</enabled>
                    <updatePolicy>always</updatePolicy>
                    </snapshots>
                </repository>
            </repositories>

        </profile>
    </profiles>
<activeProfiles/>
</settings>
