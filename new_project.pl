#!/usr/bin/perl

use strict;
use warnings;

my $problem_number = $ARGV[0];
die "Usage: ./new_project <problem_number>" unless $problem_number;

my $project_name = "problem-$problem_number";
if(-e $project_name) {
    die "A project of name '$project_name' already exists.  Delete it first if you really want a new project of that name\n";
}
`mkdir $project_name`;

my $src_dir = "$project_name/src/main/scala/euler";
`mkdir -p $src_dir`;

my $rsc_dir = "$project_name/src/main/resources";
`mkdir -p $rsc_dir`;

my $test_dir = "$project_name/src/test/scala/euler";
`mkdir -p $test_dir`;

open(POM, ">$project_name/pom.xml") or die "Could not open pom.xml for editing $!";
print POM<<EOF;
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">

    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.opower</groupId>
        <artifactId>scala-parent</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../scala-parent</relativePath>
    </parent>
    <groupId>com.opower</groupId>
    <artifactId>$project_name</artifactId>
    <version>1.0-SNAPSHOT</version>
    <name>Problem ${problem_number}: FILL IN DESCRIPTION HERE</name>

    <dependencies>
        <dependency>
            <groupId>org.scala-lang</groupId>
            <artifactId>scala-library</artifactId>
        </dependency>
        <dependency>
            <groupId>com.opower</groupId>
            <artifactId>euler-support</artifactId>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
        </dependency>
        <dependency>
            <groupId>org.scalatest</groupId>
            <artifactId>scalatest_2.9.1</artifactId>
        </dependency>
    </dependencies>
</project>
EOF
close(POM);

open(APP, ">$src_dir/App.scala") or die "Could not open App.scala for editing $!";
print APP<<EOF;
package euler.problem$problem_number

import euler.LogHelper

/**
 */
object App extends LogHelper {

  def main(args: Array[String]) {

  }
}
EOF
close(APP);


open(TEST, ">$test_dir/AppSuite.scala") or die "Could not open AppTest.scala for editing $!";
print TEST<<EOF;
package euler.problem$problem_number

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.junit.Assert._


\@RunWith(classOf[JUnitRunner])
class AppSuite extends FunSuite {

  test("The sum of 1+1=2") {
    assertEquals(2, 1+1)
  }
}


EOF
close(TEST);


open(NBACTIONS, ">$project_name/nbactions.xml") or die "Could not open nbactions.xml for editing $!";
print NBACTIONS<<EOF;
<?xml version="1.0" encoding="UTF-8"?>
<actions>
        <action>
            <actionName>run</actionName>
            <goals>
                <goal>process-classes</goal>
                <goal>org.codehaus.mojo:exec-maven-plugin:1.2:exec</goal>
            </goals>
            <properties>
                <exec.classpathScope>runtime</exec.classpathScope>
                <exec.args>-classpath \%classpath euler.problem${problem_number}.App</exec.args>
                <exec.executable>java</exec.executable>
            </properties>
        </action>
        <action>
            <actionName>debug</actionName>
            <goals>
                <goal>process-classes</goal>
                <goal>org.codehaus.mojo:exec-maven-plugin:1.2:exec</goal>
            </goals>
            <properties>
                <exec.classpathScope>runtime</exec.classpathScope>
                <exec.args>-Xdebug -Xrunjdwp:transport=dt_socket,server=n,address=\${jpda.address} -classpath \%classpath euler.problem${problem_number}.App</exec.args>
                <jpda.listen>true</jpda.listen>
                <exec.executable>java</exec.executable>
            </properties>
        </action>
        <action>
            <actionName>profile</actionName>
            <goals>
                <goal>process-classes</goal>
                <goal>org.codehaus.mojo:exec-maven-plugin:1.1.1:exec</goal>
            </goals>
            <properties>
                <exec.args>\${profiler.args} -classpath \%classpath euler.problem${problem_number}.App</exec.args>
                <profiler.action>profile</profiler.action>
                <exec.executable>\${profiler.java}</exec.executable>
            </properties>
        </action>
</actions>

EOF
close(NBACTIONS);

open(LOG4J, ">$rsc_dir/log4j.properties") or die "Could not open log4j.properties for editing $!";
print<<EOF;
log4j.debug=true
log4j.rootLogger=WARN, file, debug

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%-5p [%5.15t] %d [%.30c] %m%n

log4j.logger.euler=DEBUG

log4j.appender.file=org.apache.log4j.RollingFileAppender
log4j.appender.file.threshold=INFO
log4j.appender.file.append=false
log4j.appender.file.file=target/output.log
log4j.appender.file.MaxFileSize=16384KB
log4j.appender.file.MaxBackupIndex=3
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%-5p %d [%c{3}] %m%n

log4j.appender.debug=org.apache.log4j.RollingFileAppender
log4j.appender.debug.threshold=DEBUG
log4j.appender.debug.append=false
log4j.appender.debug.file=target/debug.log
log4j.appender.debug.MaxFileSize=16384KB
log4j.appender.debug.MaxBackupIndex=1
log4j.appender.debug.layout=org.apache.log4j.PatternLayout
log4j.appender.debug.layout.ConversionPattern=%-5p %d [%c{3}] %m%n
EOF
close(LOG4J)


print "Created new project: $project_name\n";

