#!/usr/bin/perl -w
use warnings;
use strict;
while( <STDIN> ){
	if (/"[^"]+","[^"]+","([^"]+)","([^"]+)","([^"]+)"/){
		print_subnets($1, $2, $3);
	}
}

sub  print_subnets {
	my ($a1, $a2, $c) = @_;
	my $l;
    while ($a1 <= $a2) {
		for ($l = 0; ($a1 & (1 << $l)) == 0 && ($a1 + ((1 << ($l + 1)) - 1)) <= $a2; $l++){};
		print long2ip($a1) . "/" . (32 - $l) . " " . $c . ";\n";
    	$a1 += (1 << $l);
	}
}

sub long2ip {
	my $ip = shift;

	my $str = 0;

	$str = ($ip & 255);

	$ip >>= 8;
	$str = ($ip & 255).".$str";

	$ip >>= 8;
	$str = ($ip & 255).".$str";

	$ip >>= 8;
	$str = ($ip & 255).".$str";
}
