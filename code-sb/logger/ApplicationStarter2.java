
package com.example.demo.logger;

import org.slf4j.*;

public class ApplicationStarter2 {

	private static final Logger	LOGGER	= LoggerFactory.getLogger( "fixWindowBased" );

	public static void main( final String[] args ) {



		for ( int i = 1; i <= 100; i++ ) {
			LOGGER.info( "write log with FixedWindowRollingPolicy" );

			try {
				Thread.sleep( 200L );
			} catch ( final InterruptedException e ) {
				LOGGER.error( "an error occurred", e );
			}
		}
	}
}
