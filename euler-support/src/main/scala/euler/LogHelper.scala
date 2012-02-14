package euler

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import java.util.Locale

/**
 * <p>From http://www.uncarved.com/blog/LogHelper.mrk</p>
 * 
 * <p>LogHelper is a trait you can mix in to provide easy log4j logging 
 * for your scala classes. </p>
 **/
trait LogHelper {
  val loggerName = this.getClass.getName
  lazy val logger = Logger.getLogger(loggerName)
  lazy val locale = Locale.getDefault
  
  def debug(message: String, args: Any*) {
    log(Priority.DEBUG, message, args:_*)
  }
    
  def info(message: String, args: Any*) {
    log(Priority.INFO, message, args:_*)
  }
  
  def warn(message: String, args: Any*) {
    log(Priority.WARN, message, args:_*)
  }
  
  def error(message: String, args: Any*) {
    log(Priority.ERROR, message, args:_*)
  }
  
  private def log(priority: Priority, message: String, args: Any*) {
    if(logger.isEnabledFor(priority)) {
      logger.log(priority, message.format(args:_*))
    }
  }
}