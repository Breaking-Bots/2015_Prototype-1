package org.usfirst.frc.team5428.robot.math;

/**\
 * Class representing a two dimensional vector
 * @author Zaeem
 * @version 1.0
 */
public class V2{

	/**
	 * This Vector represents the axis of X, 
	 * which is (1,0)
	 * @Warning Never under any circumstances ever, 
	 * do any methods that modify the value of this vector
	 * on this instance. This is used as an easy way to represent
	 * the X axis
	 */
	public static final V2 X = new V2(1,0);
	/**
	 * This Vector represents the axis of Y, 
	 * which is (0,1)
	 * @Warning Never under any circumstances ever, 
	 * do any methods that modify the value of this vector
	 * on this instance. This is used as an easy way to represent
	 * the Y axis
	 */
	public static final V2 Y = new V2(0,1);
	/**
	 * This Vector represents a vector with the value of zero, 
	 * which is (0,0)
	 * @Warning Never under any circumstances ever, 
	 * do any methods that modify the value of this vector
	 * on this instance. This is used as an easy way to represent zero
	 */
	public static final V2 ZERO = new V2();

	private float x;
	private float y;

	/** Constructs a new vector at (0,0) */
	public V2() {
	}
	/**
	 * Constructs a new vector with both components set to a scalar quantity
	 * @param s - the scalar
	 */
	public V2(float s) {
		this.set(s);
	}
	
	/** Constructs a vector with the given components
	 * @param x - The x-component
	 * @param y - The y-component */
	public V2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	/** Constructs a vector with the given components
	 * @param x - The x-component
	 * @param y - The y-component */
	public V2(double x, double y) {
		this.x = (float)x;
		this.y = (float)y;
	}
	/** Constructs a vector from the given vector
	 * @param v - The vector */
	public V2(final V2 v) {
		this.set(v);
	}
	
	public V2 copy() {
		return new V2(this);
	}

	
	public float length() {
		return (float) Math.sqrt(x * x + y * y);
	}

	
	public float length2() {
		return x * x + y * y;
	}

	
	public V2 limit(float limit) {
		if (length2() > limit * limit) {
			return new V2(this).normalize().mul(limit);
		}
		return this;
	}

	
	public V2 clamp(float min, float max) {
		final float l2 = length2();
		
		if (l2 == 0f)
			return this;
		if (l2 > max * max){
			return new V2(this).normalize().mul(max);
		}
		if (l2 < min * min){
			return new V2(this).normalize().mul(min);
		}
		return this;
	}

	
	public V2 set(final V2 v) {
		x = v.x;
		y = v.y;
		return this;
	}

	
	public V2 set(float s) {
		x = s;
		y = s;
		return this;
	}
	
	/** Sets the components of this vector
	 * @param x -  The x-component
	 * @param y -  The y-component
	 * @return This vector */
	public V2 set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}

	
	public float max() {
		return Math.max(x, y);
	}

	
	public float min() {
		return Math.min(x, y);
	}

	
	public V2 normalize() {
		float length = length();
		float _x = 0;
		float _y = 0;
		if (length != 0) {
			_x = x / length;
			_y = y / length;
		}
		return new V2(_x, _y);
	}

	
	public V2 add(final V2 v) {
		return add(v.x, v.y);
	}

	
	public V2 sub(final V2 v) {
		return sub(v.x, v.y);
	}

	
	public V2 mul(final V2 v) {
		return mul(v.x, v.y);
	}

	
	public V2 add(float s) {
		return add(s, s);
	}

	
	public V2 sub(float s) {
		return sub(s, s);
	}

	
	public V2 mul(float s) {
		return mul(s, s);
	}

	
	/** Adds the other vector to this vector.
	 * @param x - The x-component of the other vector
	 * @param y - The y-component of the other vector
	 * @return This vector */
	public V2 add(float x, float y) {
		return new V2(this.x + x, this.y + y);
	}
	/** Subtracts the other vector from this vector.
	 * @param x - The x-component of the other vector
	 * @param y - The y-component of the other vector
	 * @return This vector */
	public V2 sub(float x, float y) {
		return new V2(this.x - x, this.y - y);
	}
	/** Multiplies the other vector by this vector.
	 * @param x - The x-component of the other vector
	 * @param y - The y-component of the other vector
	 * @return This vector */
	public V2 mul(float x, float y) {
		return new V2(this.x * x, this.y * y);
	}
	
	public V2 mulAdd(final V2 v, float s) {
		return new V2(x + v.x * s, y + v.y * s);
	}

	
	public V2 mulAdd(final V2 vA, final V2 vM) {
		return new V2(x + vA.x * vM.x, y + vA.y * vM.y);
	}

	
	public V2 setZero() {
		this.x = 0;
		this.y = 0;
		return this;
	}

	
	public float dot(final V2 v) {
		return x * v.x + y * v.y;
	}

	
	public float dot(float s) {
		return x * s + y * s;
	}

	public float dot(float ox, float oy) {
		return x * ox + y * oy;
	}
	/** Calculates the 2D cross product between this and the given vector.
	 * @param v - the other vector
	 * @return the cross product */
	public float cross(final V2 v) {
		return this.x * v.y - this.y * v.x;
	}
	/** Calculates the 2D cross product between this and the given vector components.
	 * @param x - the x-coordinate of the other vector
	 * @param y - the y-coordinate of the other vector
	 * @return the cross product */
	public float cross(float x, float y) {
		return this.x * y - this.y * x;
	}
	/** @return the angle in degrees of this vector (point) relative to the x-axis. 
	 * Angles are towards the positive y-axis (typically
	 *         counter-clockwise) and between 0 and 360. */
	public float angle() {
		float angle = MC.toR((float) MC.atan2(y, x));
		if (angle < 0)
			angle += 360;
		return angle;
	}
	/** @return the angle in degrees of this vector (point) relative to the given vector.
	 *  Angles are towards the positive y-axis
	 *         (typically counter-clockwise.) between -180 and +180 */
	public float angle(final V2 v) {
		return MC.toR((float) MC.atan2(cross(v), dot(v)));
	}
	/** @return the angle in radians of this vector (point) relative to the x-axis.
	 *  Angles are towards the positive y-axis.
	 *         (typically counter-clockwise) */
	public float angleRad() {
		return (float) MC.atan2(y, x);
	}
	/** @return the angle in radians of this vector (point) relative to the given vector
	 * . Angles are towards the positive y-axis.
	 *         (typically counter-clockwise.) */
	public float angleRad(final V2 reference) {
		return (float) MC.atan2(cross(reference), dot(reference));
	}
	/** Sets the angle of the vector in degrees relative to the x-axis,
	 *  towards the positive y-axis (typically counter-clockwise).
	 * @param degrees The angle in degrees to set. */
	public V2 setAngle(float degrees) {
		return setAngleRad(MC.toR(degrees));
	}
	/** Sets the angle of the vector in radians relative to the x-axis,
	 *  towards the positive y-axis (typically counter-clockwise).
	 * @param radians The angle in radians to set. */
	public V2 setAngleRad(float radians) {
		return new V2(this).set(length(), 0f).rotateRad(radians);
	}
	/** Rotates the Vector2 by the given angle, counter-clockwise
	 *  assuming the y-axis points up.
	 * @param degrees the angle in degrees */
	public V2 rotate(float degrees) {
		return rotateRad(MC.toR(degrees));
	}
	/** Rotates the Vector2 by the given angle, counter-clockwise
	 *  assuming the y-axis points up.
	 * @param radians the angle in radians */
	public V2 rotateRad(float radians) {
		float cos = (float) MC.cos(radians);
		float sin = (float) MC.sin(radians);

		return new V2(this.x * cos - this.y * sin, this.x * sin + this.y * cos);
	}
	
	/** Rotates the Vector2 by 90 degrees in the specified direction,
	 *  where true is counter-clockwise and false is clockwise. */
	public V2 rotate90(boolean dir) {
		float _x = this.x;
		float _y = this.y;
		if (dir) {
			float temp = this.x;
			_x = -y;
			_y = temp;
		} else {
			float temp = this.x;
			_x = y;
			_y = -temp;
		}
		return new V2(_x, _y);
	}

	
	public V2 reflect(final V2 normal) {
		return this.sub(normal.mul(this.dot(normal) * 2));
	}

	
	public float distance(final V2 v) {
		final float x_d = v.x - x;
		final float y_d = v.y - y;
		return (float) Math.sqrt(x_d * x_d + y_d * y_d);
	}
	/** @param x - The x-component of the other vector
	 * @param  y - The y-component of the other vector
	 * @return the distance between this and the other vector */
	public float distance(float x, float y) {
		final float x_d = x - this.x;
		final float y_d = y - this.y;
		return (float) Math.sqrt(x_d * x_d + y_d * y_d);
	}

	
	public float distance2(final V2 v) {
		final float x_d = v.x - x;
		final float y_d = v.y - y;
		return x_d * x_d + y_d * y_d;
	}
	/** @param x - The x-component of the other vector
	 * @param  y - The y-component of the other vector
	 * @return the squared distance between this and the other vector */
	public float distance2(float x, float y) {
		final float x_d = x - this.x;
		final float y_d = y - this.y;
		return x_d * x_d + y_d * y_d;
	}

	
	public V2 lerp(final V2 target, float alpha) {
		final float invAlpha = 1.0f - alpha;
		return new V2((x * invAlpha) + (target.x * alpha), (y * invAlpha) + (target.y * alpha));
	}

	
	public boolean isUnit() {
		return isUnit(0.000000001f);
	}

	
	public boolean isUnit(float margin) {
		return Math.abs(length2() - 1f) < margin;
	}

	
	public boolean isZero() {
		return x == 0 && y == 0;
	}

	
	public boolean isZero(float margin) {
		return length2() < margin;
	}

	
	public boolean isOnLine(final V2 other, float epsilon) {
		return MC.isZero(x * other.y - y * other.x, epsilon);
	}

	
	public boolean isOnLine(final V2 other) {
		return MC.isZero(x * other.y - y * other.x);
	}

	
	public boolean isCollinear(final V2 other, float epsilon) {
		return isOnLine(other, epsilon) && dot(other) > 0f;
	}

	
	public boolean isCollinear(final V2 other) {
		return isOnLine(other) && dot(other) > 0f;
	}

	
	public boolean isCollinearOpposite(final V2 other, float epsilon) {
		return isOnLine(other, epsilon) && dot(other) < 0f;
	}

	
	public boolean isCollinearOpposite(final V2 other) {
		return isOnLine(other) && dot(other) < 0f;
	}

	
	public boolean isPerpendicular(final V2 other) {
		return MC.isZero(dot(other));
	}

	
	public boolean isPerpendicular(final V2 other, float epsilon) {
		return MC.isZero(dot(other), epsilon);
	}

	
	public boolean hasSameDirection(final V2 other) {
		return dot(other) > 0;
	}

	
	public boolean hasOppositeDirection(final V2 other) {
		return dot(other) < 0;
	}

	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 17;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		V2 other = (V2) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		return true;
	}

	
	public boolean epsilonEquals(V2 other, float epsilon) {
		if (other == null)
			return false;
		if (Math.abs(other.x - x) > epsilon)
			return false;
		if (Math.abs(other.y - y) > epsilon)
			return false;
		return true;
	}
	/** Compares this vector with the other vector, using the supplied epsilon for fuzzy equality testing.
	 * @return whether the vectors are the same. */
	public boolean epsilonEquals(float x, float y, float epsilon) {
		if (Math.abs(x - this.x) > epsilon)
			return false;
		if (Math.abs(y - this.y) > epsilon)
			return false;
		return true;
	}

	
	public float x() {
		return x;
	}

	
	public float y() {
		return y;
	}

	
	public float z() {
		System.err.println("V2's dont have a z-component!");
		new AssertionError().printStackTrace();
		System.exit(0);
		return 0;
	}
}