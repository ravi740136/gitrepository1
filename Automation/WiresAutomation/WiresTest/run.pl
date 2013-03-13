#!/usr/bin/perl
use Cwd;

# set the perl environment variable PATH
$currentDir= getcwd();
$ENV{'M2_HOME'}= $currentDir.'/src/test/resources/apache-maven-3.0.4';
$ENV{'PATH'} = $ENV{'PATH'}.';'.$ENV{'M2_HOME'}.'/bin';

system("mvn clean test");
