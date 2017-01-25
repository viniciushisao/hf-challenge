package br.com.hisao.hf.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.hisao.hf.LoginActivity;
import br.com.hisao.hf.R;
import br.com.hisao.hf.models.Recipe;
import br.com.hisao.hf.modelsweb.WebSession;


public class RecipeDetailFragment extends Fragment {

    private static final String ARG_PARAM_RECIPE = "arg_param_recipe";
    private static final int RED = 0xFFFF0000;
    private static final int WHITE = 0xFFFFFFFF;

    private Recipe recipe;

    private OnFragmentInteractionListener mListener;

    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;

    public RecipeDetailFragment() {
    }


    public static RecipeDetailFragment newInstance(Recipe recipe) {
        RecipeDetailFragment fragment = new RecipeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM_RECIPE, recipe);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            recipe = getArguments().getParcelable(ARG_PARAM_RECIPE);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receipt_detail, container, false);

        star1 = (ImageView) view.findViewById(R.id.star1);
        star2 = (ImageView) view.findViewById(R.id.star2);
        star3 = (ImageView) view.findViewById(R.id.star3);
        star4 = (ImageView) view.findViewById(R.id.star4);
        star5 = (ImageView) view.findViewById(R.id.star5);
        final ImageView like = (ImageView) view.findViewById(R.id.like);
        final ImageView ingrediets = (ImageView) view.findViewById(R.id.ingredients);
        final TextView description = (TextView) view.findViewById(R.id.description);
        final TextView name = (TextView) view.findViewById(R.id.name);

        description.setText(recipe.getDescription());
        name.setText(recipe.getName());
        ingrediets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.openIngredientsList(recipe.getIngredients());
            }
        });

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like.setBackgroundColor(RED);
                computeVoteLike();
            }
        });


        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickStar(view);
            }
        });
        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickStar(view);
            }
        });
        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickStar(view);
            }
        });
        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickStar(view);
            }
        });
        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickStar(view);
            }
        });

        return view;
    }

    private void onClickStar(View view) {
        ImageView imageView = (ImageView) view;
        int vote = 0;

        switch (imageView.getId()) {

            case R.id.star1:
                star1.setBackgroundColor(RED);
                star2.setBackgroundColor(WHITE);
                star3.setBackgroundColor(WHITE);
                star4.setBackgroundColor(WHITE);
                star5.setBackgroundColor(WHITE);
                vote = 1;
                break;

            case R.id.star2:
                star1.setBackgroundColor(RED);
                star2.setBackgroundColor(RED);
                star3.setBackgroundColor(WHITE);
                star4.setBackgroundColor(WHITE);
                star5.setBackgroundColor(WHITE);
                vote = 2;
                break;

            case R.id.star3:
                star1.setBackgroundColor(RED);
                star2.setBackgroundColor(RED);
                star3.setBackgroundColor(RED);
                star4.setBackgroundColor(WHITE);
                star5.setBackgroundColor(WHITE);
                vote = 3;
                break;

            case R.id.star4:
                star1.setBackgroundColor(RED);
                star2.setBackgroundColor(RED);
                star3.setBackgroundColor(RED);
                star4.setBackgroundColor(RED);
                star5.setBackgroundColor(WHITE);
                vote = 4;
                break;

            case R.id.star5:
                star1.setBackgroundColor(RED);
                star2.setBackgroundColor(RED);
                star3.setBackgroundColor(RED);
                star4.setBackgroundColor(RED);
                star5.setBackgroundColor(RED);
                vote = 5;
                break;
            default:

        }
        computeVoteStar(vote);
    }

    private void showMessageNotLogged() {

        new AlertDialog.Builder(getContext())
                .setTitle("Login required")
                .setMessage("To compute your vote you need to be logged. Do you want to login?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                }).show();
    }

    private void computeVoteStar(int vote) {
        if (!WebSession.getInstance().isLogged()) {
            showMessageNotLogged();
        } else {
            //TODO compute vote
        }


    }

    private void computeVoteLike() {
        if (!WebSession.getInstance().isLogged()) {
            showMessageNotLogged();
        } else {
            //TODO compute vote
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void openIngredientsList(List<String> ingredients);
    }
}
