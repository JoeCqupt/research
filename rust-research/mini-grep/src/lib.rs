use std::fmt::Error;

pub struct Config {
    pub query: String,
    pub filename: String,
}

impl Config {
    pub fn new(args: &Vec<String>) -> Result<Config, Error> {
        if args.len() < 3 {
            panic!("args not enough!");
        }
        
        Ok(Config {
            query: args[1].clone(),
            filename: args[2].clone(),
        })
    }
}
