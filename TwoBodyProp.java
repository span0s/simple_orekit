import org.apache.commons.math3.util.FastMath;
import org.orekit.errors.OrekitException;
import org.orekit.frames.Frame;
import org.orekit.frames.FramesFactory;
import org.orekit.time.TimeScale;
import org.orekit.time.TimeScalesFactory;
import org.orekit.time.AbsoluteDate;
import org.orekit.orbits.KeplerianOrbit;
import org.orekit.orbits.Orbit;
import org.orekit.orbits.PositionAngle;

public class TwoBodyProp {
    public static void main(String[] args) {
        try {
            double a = 24396159; // semi major axis in meters
            double e = 0.72831215; // eccentricity
            double i = FastMath.toRadians(7); // inclination
            double omega = FastMath.toRadians(180); // perigee argument
            double raan = FastMath.toRadians(261); // right ascension of ascending node
            double lM = 0; // mean anomaly

            // Inertial frame
            Frame inertialFrame = FramesFactory.getEME2000();

            // Initial date in UTC time scale
            TimeScale utc = TimeScalesFactory.getUTC();
            AbsoluteDate initialDate = new AbsoluteDate(2004, 01, 01, 23, 30, 00.000, utc);

            // gravitation coefficient
            double mu =  3.986004415e+14;

            // Orbit construction as Keplerian
            Orbit initialOrbit = new KeplerianOrbit(
                a, e, i, omega, raan, lM, PositionAngle.MEAN, inertialFrame, initialDate, mu
            );
        } catch (OrekitException oe) {
            System.out.println(oe.getMessage());
        }
    }
}
