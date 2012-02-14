package euler

class SomeClassUsingLogHelper extends LogHelper {

    debug("We got ourselves a class that can debug")
    
    info("We got ourselves a class that can %s", "info")
    
    warn("We got ourselves a %s that can debug %d times", "class", 3)
    
}