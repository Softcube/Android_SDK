package softcube.com.shopsample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softcube.softcubelib.SoftCubeClient;
import com.softcube.softcubelib.model.CartItem;
import com.softcube.softcubelib.model.StatusCartData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import softcube.com.shopsample.dummy.DummyContent;

public class ShopingCartActivity extends AppCompatActivity {
    SoftCubeClient softCubeClient;
    TextView totalLabel;
    TextView priceLabel;
    StatusCartData cartData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        softCubeClient = new SoftCubeClient(this);
        setContentView(R.layout.activity_shoping_cart);

        totalLabel = (TextView) findViewById(R.id.total);
        priceLabel = (TextView) findViewById(R.id.price);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random randomGenerator = new Random();
                int randomInt = randomGenerator.nextInt(2000);
                String orderNumber = "" + randomInt;
                softCubeClient.purchasedItems(orderNumber, cartData.getGUID());
                DummyContent.CART.clear();
                finish();

            }
        });

        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(new ArrayList<DummyContent.DummyItem>(DummyContent.CART.values())));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<DummyContent.DummyItem> mValues;

        public SimpleItemRecyclerViewAdapter(List<DummyContent.DummyItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_cart_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).content);
            holder.mPrice.setText(String.format(getString(R.string.price), mValues.get(position).price));
            holder.mQuantity.setText("X"+mValues.get(position).quantity);
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public final TextView mQuantity;
            public final TextView mPrice;
            public DummyContent.DummyItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.title);
                mContentView = (TextView) view.findViewById(R.id.content);
                mQuantity = (TextView) view.findViewById(R.id.quantity);
                mPrice = (TextView) view.findViewById(R.id.price_cart);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        softCubeClient.pageView("ShoppingCartPage");
        doCart();
    }

    private void doCart() {
        int total = 0;
        double price = 0;
        List<CartItem> items = new ArrayList<CartItem>();
        for(DummyContent.DummyItem di : DummyContent.CART.values()){
            total+=di.quantity;
            price+= (di.quantity * di.price);
            CartItem ci = CartItem.create(di.id, di.price*di.quantity, "USD", di.quantity, di.price);
            items.add(ci);
        }
        cartData = softCubeClient.statusCart(items);

        priceLabel.setText(String.format(getString(R.string.price), price));
        totalLabel.setText(String.format(getString(R.string.total), total));

    }
}
