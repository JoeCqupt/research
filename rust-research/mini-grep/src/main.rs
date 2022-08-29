use std::{env::args, process};

use mini_grep::Config;

fn main() {
    let args: Vec<String> = args().collect();
    let config = Config::new(&args).unwrap_or_else(|err| {
        eprintln!("error args: {}" , err);
        process::exit(1);
    }
    );

    println!("> query:{}", config.query);
    println!("> filename:{}", config.filename);
    
}
