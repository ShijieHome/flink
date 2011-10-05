package eu.stratosphere.sopremo.jsondatamodel;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import eu.stratosphere.pact.common.type.Key;
import eu.stratosphere.pact.common.type.base.PactNull;

public class NullNode extends JsonNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5057162510515824922L;

	private final static NullNode instance = new NullNode();

	public NullNode() {

	}

	public static NullNode getInstance() {
		return instance;
	}

	@Override
	public StringBuilder toString(StringBuilder sb) {
		return sb.append("null");
	}

	@Override
	public boolean equals(final Object o) {
		return (o instanceof NullNode) ? true : false;
	}

	@Override
	public int getTypePos() {
		return TYPES.NullNode.ordinal();
	}

	@Override
	public NullNode canonicalize() {
		return instance;
	}

	@Override
	public void read(final DataInput in) throws IOException {
		PactNull.getInstance().read(in);
	}

	@Override
	public void write(final DataOutput out) throws IOException {
		PactNull.getInstance().write(out);
	}

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public TYPES getType() {
		return TYPES.NullNode;
	}

	@Override
	public int compareTo(Key other) {
		return (other instanceof NullNode) ? 0 : 1;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeBoolean(false);
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.readBoolean();
	}
}
