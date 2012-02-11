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
    <name>Problem XXX:</name>

    <dependencies>
        <dependency>
            <groupId>org.scala-lang</groupId>
            <artifactId>scala-library</artifactId>
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

open(APP, ">$src_dir/App.scala") or die "COuld not open App.scala for editing $!";
print APP<<EOF;
package euler.problem$problem_number

/**
 */
object App {

  def main(args: Array[String]) {

  }
}
EOF
close(APP);


open(TEST, ">$test_dir/AppTest.scala") or die "Could not open AppTest.scala for editing $!";
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

print "Created new project: $project_name\n";

